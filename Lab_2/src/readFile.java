import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readFile {
	public static void main(String[] args) throws IOException{
		String fileLocation = "Y:\\Downloads\\regional-global-weekly-latest.csv";
		BufferedReader rd = new BufferedReader(new FileReader(fileLocation)); // opens file input stream
		//reads the file line by line
		String line = "";
		Scanner sc = new Scanner(rd); // scanner to read the lines from file stream
		List<Artist> lst = new ArrayList<>(); // make an array list to store data from Artist objects
		
		while((sc.hasNextLine())) {
			Artist artist = new Artist();
			line = sc.nextLine();
			String[] arr = line.split(",");
			artist.setRanking(arr[0]);
			artist.setName(arr[2]);
			artist.setSong(arr[1]);
			artist.setHits(arr[3]);
			artist.setUrl(arr[4]);
			//index = 0;
			lst.add(artist);
		}
		sc.close(); // close the buffer
		for (Artist x : lst) {
			System.out.print(x.toString());
			System.out.println("");
		}
	}
}
