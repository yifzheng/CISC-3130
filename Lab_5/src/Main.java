import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static SongPlaylist lst = new SongPlaylist();

	public static void main(String[] args) throws IOException {
		String[] fileLocation = { "Y:\\Downloads\\regional-global-weekly-2020-09-11--2020-09-18.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-09-18--2020-09-25.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-09-25--2020-10-02.csv",
				"Y:\\Downloads\\regional-global-weekly-2020-10-02--2020-10-09.csv" }; // file location

		ArrayList<String> songList = new ArrayList<>(); // an array list to store all the song tracks
		songList.ensureCapacity(1000); // ensures capacity for 5 input files
		ArrayList<String> artistList = new ArrayList<>(); // an array list to store all arist names
		artistList.ensureCapacity(1000); // ensures capacity for 5 input files
		ArrayList<Integer> streamList = new ArrayList<>(); // an array list to store all stream counts
		streamList.ensureCapacity(1000); // ensures capacity for 5 input files
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
		lst.inorderTransversal();
		// lst.subset("Blinding Lights", "Pretty Savage");
	}

	// makes a queue of Song objects from 3 lists
	public static void makeBST(ArrayList<String> songLst, ArrayList<String> artistLst, ArrayList<Integer> streamLst) {
		for (int i = 0; i < songLst.size(); i++) {
			Song artist = new Song(songLst.get(i), artistLst.get(i), streamLst.get(i)); // make song objct with elements
																						// from each list
			lst.insert(artist); // insert object into BST
		}
	}

	/*
	 * // make a BST from queue public static void BST(Queue<Song> queue) { while
	 * (!queue.isEmpty()) { lst.insert(queue.poll()); } }
	 */
}
