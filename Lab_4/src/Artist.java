import java.util.LinkedList;

public class Artist implements Comparable<Artist> {
	String name, song; // variables to store artist information
	Artist next; // Artist to next artist
	// void constructor
	public Artist() {
	}
	// constructor with two parameters
	public Artist(String name, String song) {
		this.name = name;
		this.song = song;
	}
	// method to set name to artist
	public void setName(String name) {
		this.name = name;
	}
	// method to set song to artist
	public void setSong(String song) {
		this.song = song;
	}
	
	public int compareTo(Artist obj) {
		return this.name.compareTo(obj.name);
	}
	
	public String toString() {
		return this.song + " by " + this.name;
	}
}

class PlayList{
	SongHistoryList history = new SongHistoryList();
	Artist head; // Artist to head of the list
	Artist sorted;
	Artist reverse;
	// constructor to set head to null
	public PlayList() { 
		head = null;
	}
	
	// returns true/false if head is null
	public boolean isEmpty() {
		return (head == null);
	}
	
	// pushes object to the list
	public void push(Artist obj) {
		// if the head is null, then the object in the parameter becomes the tail/lst object in linked list
		if (head == null) {
			head = obj;
			head.next = null;
		}
		// else a temp variable is made to store the object and obj is set to head 
		else {
			Artist temp = obj;
			temp.next = head;
			head = temp;
		}
	}
	
	public void append(Artist s){
		// if the head is null, then the object in the parameter becomes the tail/last object in linked list
		if (head == null) {
			head = s;
			head.next = null;
		}
		// else a temp variable is made to store the object and obj is set to head 
		else {
			Artist lastNode = getLastNode();
			lastNode.next = s;
			s.next = null;
		}
	  }
	public Artist getLastNode() {
		Artist temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}
	// prints out list in reverse order
	public void printList(Artist head) {
		if (head == null) {
			return;
		}
		System.out.println(head.song + " by " + head.name);
		printList(head.next);
	}
	
	public Artist listenToSong(){
		  if (isEmpty()) {
			  throw new IllegalArgumentException("List is empty");
		  }
		  
		  // make a temporary object to store first song
		  Artist current = head;
		  // set root node to its next node;
		  head = head.next;
		  // adds the song to the song history list
		  history.push(current);
		  // return temp node
		  return current;
	  } 
	public String displayList(Artist head) {
		if (head == null) {
			return " ";
		}
		displayList(head.next);
		
		return "Artist: " + head.name + ", Song(s): " + head.song;
	}

	void sort(Artist artist)  
    { 
        // Initialize sorted linked list 
        sorted = null; 
        Artist current = artist; 
        // Traverse the given linked list and insert every Artist to sorted 
        while (current != null)  
        { 
        	Artist next = current.next;
            // insert current in sorted linked list 
            insert(current); 
            // Update current 
            current = next; 
        } 
        // Update head_ref to point to sorted linked list 
        head = sorted; 
    } 
  
     // function to insert a new_Artist in a list and modify the head of the input linked list  
    void insert(Artist artist)  
    { 
        /* Special case for the head end */
        if (sorted == null || sorted.song.toUpperCase().compareTo(artist.song.toUpperCase()) > 0)  
        { 
            artist.next = sorted; 
            sorted = artist; 
        } 
        else 
        { 
            Artist current = sorted; 
            /* Locate the Artist before the point of insertion */
            while (current.next != null && current.next.song.toUpperCase().compareTo(artist.song.toUpperCase()) < 0)  
            { 
                current = current.next; 
            } 
            artist.next = current.next; 
            current.next = artist; 
        } 
    } 
    // method to remove the artist with duplicates and add the song names into one artist object
    void removeDuplicates() {
    	Artist ref1 = head;
    	Artist ref2 = null;
    	while (ref1 != null && ref1.next != null) {
    		ref2 = ref1;
    		while (ref2.next != null) {
    			// if 1st Artist name is equal to the next Artist name, we add the next artist name to the 1st artist name
    			if (ref1.name.compareTo(ref2.next.name) == 0) {
    				String songName = ref2.next.song + " | " + ref1.song ;
    				ref1.setSong(songName);
    				ref2.next = ref2.next.next;
    				System.gc();
    			}
    			else {
    				ref2 = ref2.next;
    			}
    		}
    		ref1 = ref1.next;
    	}
    }
    
    void removeDup() {
    	Artist ref1 = head;
    	Artist ref2 = null;
    	while (ref1 != null && ref1.next != null) {
    		ref2 = ref1;
    		while (ref2.next != null) {
    			// if 1st Artist name is equal to the next Artist name, we add the next artist name to the 1st artist name
    			if (ref1.song.toLowerCase().compareTo(ref2.next.song.toLowerCase()) == 0) {
        			ref2.next = ref2.next.next;
        			System.gc();
    			}
    			else {
    				ref2 = ref2.next;
    			}
    		}
    		ref1 = ref1.next;
    	}
    }
    void reverseList(Artist artist) {
    	 // Initialize sorted linked list 
        reverse = null; 
        Artist current = artist; 
        // Traverse the given linked list and insert every Artist to sorted 
        while (current != null)  
        { 
        	Artist next = current.next;
            // insert current in sorted linked list 
            insertList(current); 
            // Update current 
            current = next; 
        } 
        // Update head_ref to point to sorted linked list 
        head = reverse; 
    }
    
    void insertList(Artist artist) {
    	if (reverse == null) {
    		artist.next = reverse;
    		reverse = artist;
    	}
    	else {
    		Artist temp = artist;
    		temp.next = reverse;
    		reverse = temp;
    	}
    }
    
    
}