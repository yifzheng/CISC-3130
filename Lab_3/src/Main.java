import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		String fileLocation = "Y:\\Downloads\\regional-global-weekly-2020-09-18--2020-09-25.csv"; //https://spotifycharts.com/regional/global/weekly/2020-09-18--2020-09-25
		//reads the file line by line
		String line = "";
		// scanner to read the lines from file stream
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileLocation))); 
		ArtistList lst = new ArtistList();
		// each row is an artist object and there are methods to set values to the variables in the artist class
		// this code is based on the format of the csv file not applicable for all files
		while((sc.hasNextLine())) {
			Artist artist = new Artist(); // make the object to store information
			line = sc.nextLine(); // set the variable equal the next line from file
			String[] arr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // split the line into parts for storing
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].charAt(0) == ('"')) {
					arr[i] = arr[i].substring(1, arr[i].length() - 1);
				}
			}
			artist.setSong(arr[1]); // sets the name of the song
			artist.setName(arr[2]); // sets the name of the artist;
			lst.push(artist); // adds the artist object to the made list
		}
		sc.close(); // close the buffer
		lst.sort(lst.head); // sort the linked list
		lst.removeDuplicates(); // remove duplicates
		lst.printList(lst.head); // print list to check if methods work as intended
		System.out.println(" ");
		
		lst.reverseList(lst.head); // reverse list
		Artist current = lst.head; // set an Artist object to head of the reversed list
		File file = new File("ArtistsSorted-WeekOf-09-18-2020--09-25-2020.csv"); // creates a new csv file
		FileWriter csvWriter = new FileWriter(file); // makes a filewriter object to write the data from the list to a new csv file
		//for every artist, use toString method to print out all necessary information
		while (current != null) { // while the object is not null
			csvWriter.write("Stage Name: " + current.name + ", Song(s): "+ current.song + "\n"); // use the csvWriter to write the artist and songs into each line
			current = current.next; // set current to next object
		}
		csvWriter.flush(); // flush fileWriter
		csvWriter.close(); // close fileWriter
	}
}
