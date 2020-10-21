import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class MyQueue {
	
	static PlayList lst = new PlayList();

	public MyQueue(String[] fileLocation) throws IOException{
		for (String x : fileLocation) {
			String line = "";
			// scanner to read the lines from file stream
			Scanner sc = new Scanner(new BufferedReader(new FileReader(x))); 
			
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
				lst.append(artist); // adds the artist object to the made list
				//lst.push(artist);
				
			}
			sc.close(); // close the buffer
		}
	}
	
	public static void makeFile(PlayList list) throws IOException{
		Artist current = list.head;
		File file = new File("total-fiscal-quarter-playlist-2020-06-26--2020-10-09.csv"); // creates a new csv file
		FileWriter csvWriter = new FileWriter(file); // makes a filewriter object to write the data from the list to a new csv file
		//for every artist, use toString method to print out all necessary information
		while (current != null) {
			csvWriter.write(current.toString()); 
			current = current.next;
		}
		csvWriter.flush(); // flush fileWriter
		csvWriter.close(); // close fileWriter
	}
	public static void playList(PlayList list) throws IOException{
		Artist current = list.head;
		File file = new File("remaining-fiscal-quarter-playlist-2020-06-26--2020-10-09.csv"); // creates a new csv file
		FileWriter csvWriter = new FileWriter(file); // makes a filewriter object to write the data from the list to a new csv file
		//for every artist, use toString method to print out all necessary information
		while (current != null) {
			csvWriter.write(current.toString()); 
			current = current.next;
		}
		csvWriter.flush(); // flush fileWriter
		csvWriter.close(); // close fileWriter
	}
	public static void playListHistory(PlayList list) throws IOException{
		Artist current = list.history.head;
		File file = new File("playlist-history-of-fiscal-quarter-playlist-2020-06-26--2020-10-09.csv"); // creates a new csv file
		FileWriter csvWriter = new FileWriter(file); // makes a filewriter object to write the data from the list to a new csv file
		//for every artist, use toString method to print out all necessary information
		while (current != null) {
			csvWriter.write(current.toString()); 
			current = current.next;
		}
		csvWriter.flush(); // flush fileWriter
		csvWriter.close(); // close fileWriter
	}
	public static void main(String[] args) throws IOException {
		
		String[] fileLocation = {"Y:\\Downloads\\regional-global-weekly-2020-06-26--2020-07-03.csv", "Y:\\Downloads\\regional-global-weekly-2020-07-03--2020-07-10.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-07-10--2020-07-17.csv", "Y:\\Downloads\\regional-global-weekly-2020-07-17--2020-07-24.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-07-24--2020-07-31.csv", "Y:\\Downloads\\regional-global-weekly-2020-07-31--2020-08-07.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-08-07--2020-08-14.csv", "Y:\\Downloads\\regional-global-weekly-2020-08-14--2020-08-21.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-08-21--2020-08-28.csv", "Y:\\Downloads\\regional-global-weekly-2020-08-28--2020-09-04.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-09-04--2020-09-11.csv", "Y:\\Downloads\\regional-global-weekly-2020-09-11--2020-09-18.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-09-18--2020-09-25.csv", "Y:\\Downloads\\regional-global-weekly-2020-09-25--2020-10-02.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-10-02--2020-10-09.csv"};
		MyQueue data = new MyQueue(fileLocation);
		
		lst.sort(lst.head);// sort the linked list
		lst.removeDup();
		lst.printList(lst.head); // print list to check if methods work as intended
		makeFile(lst); // makes file of entire playlist
		System.out.println(" ");
		
		int i = 1000;
		while (i != 0) {
			System.out.println(lst.listenToSong());
			i /= 2;
		}
		playList(lst); // makes file of playlist after listen to song is called n/2 times
		System.out.println(" ");
		
		System.out.println(lst.history.lastListened());
		playListHistory(lst);
		System.out.println(" ");
		lst.printList(lst.head);
		
	}
}