/*
public class Documentation {
	Documentation of Lab_3: (PLEASE NOTE THAT CODE IN THIS PROJECT WORKS FOR THE FILE PROVIDED IN MAIN CLASS. WEBSITE TO FILE PROVIDED IN COMMENT)
	The purpose of this lab was to input a csv file, read the information, manipulate such information and output the informatation into the desired format through a 
	linked list.
	An Artist class was made with variables Name and Song to store the artist information I desired in the csv file. Two different constructors were made, one without 
	parameters and one with paramters. Set functions were made to set values to the variables if the null constructor was used. An Artist object is made in the class as a
	node to the next Artist object. Since I will be sorting the information alphabetically, I had to implement the Comparable interface to compare the strings of Artist
	objects.
	
	An ArtistList is made to create the linked list. Artist objects were made with names head, sorted, and reverse. The latter two are used to manipulate the list and 
	set the manipulated list to head. A constructor for ArtistList is made without parameters that sets head == null. An boolean method was made to return whether the list
	was empty. A void function was made to push Artist objects into the list at the head node everytime making this list in a way a stack. Since the linkedlist was made
	by myself, sorting became a problem that I had to solve since I couldn't use the Collections library and sort the linked List. Therefore I made a sorting funtion that
	removes Artist objects node by node into the sorted object and when the insert function is done, head would be set to sorted. Basically into a new linked list. 
	Limitations in the insert function was made to sort the objects. If the list is empty or the object compared the the first node is "less" alphabetically, then it 
	would become the first node. Else it finds the artist in sorted linkedlist where the to be inserted Artist object is not less and inserts it after the node.
	A printList function is run recursively until it reaches the end if the list of bottom of the stack and prints out the values in reverse. 
	A reverse function is also made so I could reverse the list for writing the file.
	In removeDuplicates(), two reference points are made. while reference1.next is not null it loops. reference 2 is set to reference 1. while reference2.next is not null
	it loops. if the name is reference1 is equals to the name in reference2.next, the song name in reference2.next is concatonated to reference1 and reference2,next is set
	to reference2.next.next. Then the memeory is emptied. If they are not equal then reference two is set to reference2.next. outside the inner while loop, reference1 is 
	set to reference1.next.

	In the main class, a bufferedreader is made to read the information from a file. A scanner is made to read the information from the bufferedreader. Each line is taken
	from the file and split into a String[] array to store the information. An artist object is made and the desired inforamtion is set to the artist object and the object 
	is pushed to the already made ArtistList. The list is then sorted and duplicates removed. The list is then reversed and a new file is made and I take each node in the 
	reversed list to write it into the file. 
}*/
