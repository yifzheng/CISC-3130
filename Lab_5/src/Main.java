import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// global static SOngPlaylist object to be accessed throughout the class
	static SongPlaylist lst = new SongPlaylist();

	public static void main(String[] args) throws IOException {
		// file location
		String[] fileLocation = { "Y:\\Downloads\\regional-global-weekly-2020-06-26--2020-07-03.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-07-03--2020-07-10.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-07-10--2020-07-17.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-07-17--2020-07-24.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-07-24--2020-07-31.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-07-31--2020-08-07.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-08-07--2020-08-14.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-08-14--2020-08-21.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-08-21--2020-08-28.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-08-28--2020-09-04.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-09-04--2020-09-11.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-09-11--2020-09-18.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-09-18--2020-09-25.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-09-25--2020-10-02.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-10-02--2020-10-09.csv" }; 

		ArrayList<String> songList = new ArrayList<>(); // an array list to store all the song tracks
		ArrayList<String> artistList = new ArrayList<>(); // an array list to store all arist names
		ArrayList<Integer> streamList = new ArrayList<>(); // an array list to store all stream counts
		for (String x : fileLocation) {
			FileInputStream inputStream = new FileInputStream(x); // initialize inputStream with filelocation variable
			Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8.name()); // intialize scanner to read
																					// inputStream
			while (sc.hasNextLine()) { // while the scanner has a line to read
				String line = sc.nextLine(); // line taken from file
				String[] array = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // split the line into parts for
																						// Song variable declaration
				if (array.length > 1) { // checks if the array size is greater than 1 if not don't set any values to the
										// Song object
					for (int i = 0; i < array.length; i++) {
						if (array[i].charAt(0) == '"') { // if there are parenthesis in the string, remove them
							array[i] = array[i].substring(1, array[i].length() - 1);
						}
					}
					songList.add(array[1]); // adds track name into songlist
					artistList.add(array[2]); // adds artist name to list
					streamList.add(Integer.parseInt(array[3])); // adds stream count to list
				}
			}
			inputStream.close(); // close inputStream
			sc.close(); // close scanner
		}
		makeBST(songList, artistList, streamList); // make BST

		// System.out.println(lst.root);
		// System.out.println("BST of Playlist");
		// lst.inorderTranversal(); // tranverse BST inorder
		//System.out.println(" ");
		System.out.println("Subtree of main BST");
		lst.subset("Blinding Lights", "Pretty Savage"); // calls subset() to print out a subtree within range of two string arguments
		makeBSTFile(lst.BST); // calls function to make an ouput file of the BST inorder
		makeSubtreeFile(lst.branch); // calls function to make an output file from the subset() method
	}

	// makes a queue of Song objects from 3 lists
	public static void makeBST(ArrayList<String> songLst, ArrayList<String> artistLst, ArrayList<Integer> streamLst) {
		for (int i = 0; i < songLst.size(); i++) {
			Song artist = new Song(songLst.get(i), artistLst.get(i), streamLst.get(i)); // make song objct with elements
																						// from each list
			lst.insert(artist); // insert object into BST
		}
	}

	// makes an output file of the BST data with with format: this.songTitle + " by
	// " + this.artistName + " has streamed " + this.streamCount + " times and
	// streamed on average " + this.artistAverage + " times"
	public static void makeBSTFile(ArrayList<Song> list) throws IOException {
		File file = new File("BST-of-Playlist.csv"); // creates a new csv file
		FileWriter csvWriter = new FileWriter(file); // makes a filewriter object to write the data from the list to a
														// new csv file
		csvWriter.write("BST OF PLAYLIST" + "\n");
		// for every artist, use toString method to print out all necessary information
		for (Song x : list) {
			csvWriter.write(x + "\n");
		}
		csvWriter.flush(); // flush fileWriter
		csvWriter.close(); // close fileWriter
	}

	// makes an output file of the subtree called on line 64.
	public static void makeSubtreeFile(ArrayList<Song> list) throws IOException {
		File file = new File("subset-of-BST.csv"); // creates a new csv file
		FileWriter csvWriter = new FileWriter(file); // makes a filewriter object to write the data from the list to a
														// new csv file
		csvWriter.write("SUBTREE OF BST" + "\n");
		// for every artist, use toString method to print out all necessary information
		for (Song x : list) {
			csvWriter.write(x + "\n");
		}
		csvWriter.flush(); // flush fileWriter
		csvWriter.close(); // close fileWriter
	}
}
