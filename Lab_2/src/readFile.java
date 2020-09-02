import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class readFile {
	public static void main(String[] args) throws IOException{
		String fileLocation = "Y:\\Downloads\\regional-global-weekly-latest.csv";
		//reads the file line by line
		String line = "";
		// scanner to read the lines from file stream
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileLocation))); 
		// make an array list to store data from Artist objects
		List<Artist> lst = new ArrayList<>(); 
		// each row is an artist object and there are methods to set values to the variables in the artist class
		while((sc.hasNextLine())) {
			Artist artist = new Artist(); // make the object to store information
			line = sc.nextLine(); // set the variable equal the next line from file
			String[] arr = line.split(","); // split the line into parts for storing
			artist.setRanking(arr[0]); // sets the ranking of the song
			artist.setSong(arr[1]); // sets the name of the song
			artist.setName(arr[2]); // sets the name of the artist;
			artist.setHits(arr[3]); // sets the number of hits in the song
			artist.setUrl(arr[4]); // set the url
			lst.add(artist); // adds the artist object to the made list
		}
		sc.close(); // close the buffer
		for (Artist x : lst) {
			System.out.print(x.toString());
			System.out.println("");
		}
		File file = new File("Ranking.csv"); // creates a new csv file
		FileWriter csvWriter = new FileWriter(file); // makes a filewriter object to write the data from the list to a new csv file
		for (Artist x : lst) {
			//for every artist, use toString method to print out all necessary information
			csvWriter.write(x.toString() + "\n"); 
		}
		csvWriter.flush(); // flush fileWriter
		csvWriter.close(); // close fileWriter
	}

}
