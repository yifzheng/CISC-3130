import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
/*2. If an artist appears multiple times, then that artist probably should only appear once in your nested array.
3. Prepare an output file with contents of your nested array so that the record label executive can see this report. 
**Extra challenge**
1. Alphabetize the names of artists produced
2. Return list of artists produced*/
public class readFile {
	static String[][] arr = null;
	// make an array list to store data from Artist objects
	static List<Artist> lst = new ArrayList<>(); 
	public static void main(String[] args) throws IOException{
		String fileLocation = "Y:\\Downloads\\regional-global-weekly-latest.csv"; //https://spotifycharts.com/regional/global/weekly/2020-08-21--2020-08-28
		//reads the file line by line
		String line = "";
		// scanner to read the lines from file stream
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileLocation))); 
		// each row is an artist object and there are methods to set values to the variables in the artist class
		// this code is based on the format of the csv file not applicable for all files
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
		arr = new String[lst.size()][5];
		for (int i = 0; i < lst.size(); i++) {
			arr[i][0] = (lst.get(i)).getRanking();
			arr[i][1] = (lst.get(i)).getSong();
			arr[i][2] = (lst.get(i)).getName();
			arr[i][3] = (lst.get(i)).getHits();
			arr[i][4] = (lst.get(i)).getUrl();
		}
		// prints out the contents of the 2D array
		String divider = ",";
		/*for (int i = 0; i < lst.size(); i++) {
			for (int j = 0; j < 5; j++) {
				if (j != 4) {
					System.out.print(arr[i][j] + divider);
				}
				else {
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
		}*/
		//for (Artist x : lst) {
			//System.out.print(x.toString());
			//System.out.println("");
		//}
		String[][] array = countArtist(lst); // maked a 2d Array for the list made from the method to store artist, song name, and # of appearances
		//prints out content of the 2d Array
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (j != 2) {
					System.out.print(array[i][j] + divider);
				}
				else {
					System.out.print(array[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
		List<Artist> newList = arrToList(array); // converts the 2D array to a new list storing only the values set to store above
		File file = new File("Weekly_Spotify_Rankings_08282020.csv"); // creates a new csv file
		FileWriter csvWriter = new FileWriter(file); // makes a filewriter object to write the data from the list to a new csv file
		for (Artist x : newList) {
			//for every artist, use toString method to print out all necessary information
			csvWriter.write(x.twoString() + "\n"); 
		}
		csvWriter.flush(); // flush fileWriter
		csvWriter.close(); // close fileWriter
		printFile(file);
	}
	// this method sets up a 2d array arranging their names, their songs, and the number of times they've appeared on the ranking
	public static String[][] countArtist(List<Artist> list){
		List<String> newLst = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			if (!newLst.contains(list.get(i).getName())) { // if the list does not contain the element from list, the add it to the new list
				newLst.add(list.get(i).getName());
			}
		}
		String[][] array = new String[newLst.size()][3];
		for (int i = 0; i < newLst.size(); i++) {
			array[i][0] = "Artist: " + newLst.get(i) + " ";
			array[i][1] = "Song/Songs By Artist:" + getSongNames(newLst.get(i), list);
			array[i][2] = "Appearances in Spotify Ranking: " + Integer.toString(countDuplicates(newLst.get(i), list));
		}
		return array;
	}
	// counts how many times the artist appears in the ranking
	public static int countDuplicates(String str, List<Artist> list) {
		int count = 0;
		for (int i = 0; i < lst.size(); i ++) {
			if (str.equals(list.get(i).getName())) { // if the string is equals to the string variable of the object in the list
				count++; // increment the count 
			}
		}
		return count;
	}
	// puts together the names of all the songs under the same artist
	public static String getSongNames(String str, List<Artist> list) {
		String songName = "";
		for (int i = 0; i < list.size(); i++) {
			if (str.contentEquals(list.get(i).getName())) { // if the string is equals to the string variable of the object in the list
				songName = songName + " " + list.get(i).getSong(); // concatonate all the song names together
			}
		}
		return songName;
	}
	// this method converts the information from the 2D array into a list
	public static List<Artist> arrToList(String[][] array){
		List<Artist> newList = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			Artist artist = new Artist();
			artist.setName(array[i][0]);
			artist.setSong(array[i][1]);
			artist.setCount(array[i][2]);
			newList.add(artist);
		}
		return newList;
	}
	// prints the file based on the file written in main method
	public static void printFile(File file) throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader(file))); 
		String line = "";
		// each row is an artist object and there are methods to set values to the variables in the artist class
		// this code is based on the format of the csv file not applicable for all files
		List<Artist> newList = new ArrayList<>();
		while((sc.hasNextLine())) {
			Artist artist = new Artist(); // make the object to store information
			line = sc.nextLine(); // set the variable equal the next line from file
			String[] arr = line.split(","); // split the line into parts for storing
			artist.setName(arr[0]); // sets the name of the artist;
			artist.setSong(arr[1]); // sets the name of the song
			artist.setCount(arr[2]);
			newList.add(artist); // adds the artist object to the made list
		}
		sc.close(); // close the buffer
		String[][] array = new String[newList.size()][3];
		for (int i = 0; i < newList.size(); i++) {
			array[i][0] = (newList.get(i)).getName();
			array[i][1] = (newList.get(i)).getSong();
			array[i][2] = (newList.get(i)).getCount();
		}
		//prints out the contents of the 2D array
		String divider = ",";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (j != 2) {
					System.out.print(array[i][j] + divider);
				}
				else {
					System.out.print(array[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
