
public class Documentation {
	/*
	 * NOTICE: files used in this lab are subjected to change by the website. *The files should be included with the lab*. Otherwise include code into MyQueue.java in lines 19 and 20 --> fileScanner.nextLine();
	 * 
	 * General code of this lab is based on Lab 3. 
	 * 
	 * The purpose of this lab is to work with multiple input files. A fiscal quarter worth of csv files were used in this lab. Data from each file was extracted and placed into a global queue/linkedlist structure. 
	 * 
	 * Artist.java EXPLAINED:
	 * > The Artist class is the main class in the file. It has 2 variables, a node pointer, 2 different constructors, 2 set variable methods, a overridden comparable class, and one toString() method.
	 * --> Variables to store data from files are Name(to store artist name) and Song(to store track name)
	 * --> One empty constructor and one constructor with two arguments to set value to variables
	 * --> two set variable methods to set value to variables if empty constructor were to be called
	 * --> a compareTo() method returns an integer value for the difference in String value
	 * --> toString() returns track name and artist name if Artist object were to be an argument to be printed
	 * 
	 * >there is a subclass PlayList that extends LinkedList
	 * --> an initiated SongHistoryList variable history(to be explained later)
	 * --> three different root nodes for different functions below : head, sorted, reverse. Head is the root node of original queue. Sorted used to sort queue and reverse used when reversing list
	 * --> constuctor sets head == null
	 * --> isEmpty() returns whether head == null
	 * --> push() inserts nodes from head node so every new inserted node is the head node
	 * --> append() inserts nodes form the back so the first node is always the head unless the list is sorted then the smallest value is the head --> method mainly used in this lab
	 * --> getLastNode() transverses through the list until it reaches the last unnull node in the list
	 * --> printList(Artist head) prints the queue starting from head node
	 * --> listenToSong() throws IllegalArgumentException if the list is empty. Else it remove the head node, adds it to history, and then returned
	 * --> sort() and insert() are used to sort the linkedlist/queue
	 * --> removeDuplicates() remove duplicates of artist names and concatenates song names to 1 artist object
	 * --> removeDup() --method used in this lab-- remove the duplicate artist names and their osngs if there are multiple. Since multiple files are used, it is assumed that there will be multiple instances of artist name with same
	 * song appearing multiple times
	 * --> revserseList() and insertList() used to reverse the list if you want last node to be the head node
	 * 
	 * SongHistoryList.java EXPLAINED:
	 * >SongHistoryList is a class made to store the Artists removed when listenToSong() is used and stored into a new Queue/linkedlist
	 * --> root node head for queue
	 * --> isEmpty() returns whether head == null
	 * --> append() inserts nodes form the back so the first node is always the head unless the list is sorted then the smallest value is the head --> method mainly used in this lab
	 * --> getLastNode() transverses through the list until it reaches the last unNull node in the list
	 * --> printList(Artist head) prints the queue starting from head node
	 * --> lastListenedTo() returns the most recent song listen which is the last node of the queue;
	 * 
	 * MyQueue.java EXPLAINED:
	 * >classes used to for compiling the code
	 * --> global variable lst(PlayList variable) is made so it can be accessed later in the class
	 * --> constructor MyQueue(String[] fileLocation) takes in a string array argument of file locations and reads each file. Data from the file is chosen and set to Artist object made appended to global list
	 * --> makeFile(PlayList list) makes a csv of the entire playlist before any methods change it
	 * --> playList(PlayList list) makes a csv file of the remaing playlist after listenToSong() is called n number of times
	 * --> playListHistory(PlayList list) as name suggests is a file of the songs listened to after listenToSong was called n number of times
	 * --> main method:
	 * ---> String[] of file locations
	 * ---> MyQueue constructor is called with fileLocation as the argument
	 * ---> global list is the sorted, duplciates removed
	 * ---> the list after being sorted and duplicates removed is printed to make sure methods work as intended
	 * ---> makeFile(list) is called;
	 * ---> I declared i = 1000 and put listenToSong in a while loop that cancels once i reaches 0
	 * ---> playList(list) is called to make a file of the remaining playlist
	 * ---> lst.history.lastListened() is used to check if the method works as intended
	 * ---> playListHistory(list) is then called to make a file of the playlist history
	 * 
	 *>>>playlist-history-of-fiscal-quarter-playlist-2020-06-26--2020-10-09.csv<<< csv of playlist history
	 *>>>remaining-fiscal-quarter-playlist-2020-06-26--2020-10-09.csv<<< remaining playlist
	 *>>>total-fiscal-quarter-playlist-2020-06-26--2020-10-09.csv<<< total playlist from all files
	 */
}
