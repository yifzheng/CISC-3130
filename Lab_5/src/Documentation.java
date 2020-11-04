import java.util.ArrayList;

public class Documentation {
	/*
	 * ## Problem Description
	 * 
	 * A local Radio DJ wants to create a sorted playlist based on the song title
	 * name. He is in a coding class learning about data structures and tries to
	 * create the playlist using a binary search tree.
	 * 
	 * Part 1 - Storing Data
	 * 
	 * Store the song titles a binary search tree using the song title as the key
	 * used for sorting comparisons. Store the artist and average number of plays
	 * for that song, and average number of plays for that artists across the time
	 * period of your analysis. A `Song` node is provided as an example for you
	 * here, however implementation details are up to you. Choose what makes sense
	 * to you.
	 * 
	 * 
	 * Part 2 - Report
	 * 
	 * Use the `subSet()` function to help filter the list so that you can save the
	 * output to a text file.
	 * 
	 * 
	 * ```java Set sample1 = myPlayList.subSet("Jingle Bells", "Merry Christmas");
	 * ```
	 * 
	 * Explanation for Song.java 
	 * -> 4 variables, two string, 2 integer to store track name, artist name, number of streams for song, and the average number of streams throughout the files 
	 * -> two Song nodes to point to left and right side of the BST
	 * -> a null Song constructor to set all variables and nodes null or 0
	 * -> a Song() constructor with songname, artistname, and streamCOunt arguments
	 * -> There is a set and get method for every variable except artistAverage
	 * -> setArtistAverage(Song obj) is a void method that takes the objects stream count, add it to this.streamCount and divide it by two. It takes the average of both stream counts
	 * -> A compareTo(Song obj) to compare object for insertion of objects in BST
	 * -> A toString() method to print out the Objects with the song track, artist name, a stream count for the song, and the average stream count of the song from all the files
	 * 
	 * Explanation for SongPlaylist.java
	 * -> A Song root object is made as the root for the BST
	 * -> Two ArrayList<Song> lists are made to store the BSY and subtree for file output
	 * -> A SongPlaylist() constructor is made to set root = null
	 * -> An isEmpty() method returns if the BST is empty
	 * -> insert(Song obj) inserts the Song object into the BST. If the BST is empty the obj becomes the root. Else if compares the songTitle of the object to the root. If it is smaller and the root, it
	 * traverses downt he tree until a null node and inserts it into it. Vice versa if it is bigger. Furthermore, it checks if the BST already has the object it wants to insert. If it does, it calls the
	 * setArtistAverage() method is called to take the average of the Stream counts of the object and the object it is comparing it to.
	 * -> A void inorderTraversal(0 method calls a helper method inorder(root) with the root of the BST as the argument
	 * -> inorder(Song root) recursively calls itself and adds each node.object to BST list as well as prints out the node.
	 * -> subset(String str, String str2) takes two string arguments and calls a helper method with root as one of the arguments
	 * -> subset(Song root, String str, String str2) recursively calls traverses the BST and if the root.songtitle is within the range from the two string aruments, it adds to the branch lsit and prints out
	 * the object
	 * 
	 * Explanation for Main.java
	 * ->A global SongPlaylist object is made so it can be called throughout the class. 
	 * -> In main(), a string array containing 15 files is made
	 * -> Lines 35-37 are arraylist made to store information from the files
	 * -> Lines 38-60, for every file in fileLocation, a scanner reads the file, takes a line from the file and split() into a String[] to access the information individually. If there are parenthesis in each strring
	 * we remove them. Afterwards we add arr[1], arr[2]. arr[3] to their perspective arraylist. Once all the files are read, we close all methods used to read the files.
	 * -> makeBST(ArrayList<String> songLst, ArrayList<String> artistLst, ArrayList<Integer> streamLst) function is called to make a BST from the arraylists
	 * -> lines 63-68 are optional code used to test whether the BST has values and is printed properly in order
	 * -> In line 68, the subset of the BST is printed.
	 * -> makeBSTFile() function is called to make an output file of BST
	 * -> makeSUBtreeFile() function is called to maek an output file of subtree form the BST
	 * -> Lines 75-81 is the makeBST() function which takes three ArrayLists as arguments and makes a BST and stores into the SongPlaylist object
	 * -> 86-111 are the makeBSTFile() and makeSubtreeFile() functions to make an output file form arraylist
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
