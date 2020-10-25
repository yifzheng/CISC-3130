
public class SongHistoryList {
	  Artist first;
	  public SongHistoryList(){
		  first = null;
	  }
	  
	  public boolean isEmpty() {
		  return first == null;
	  }
	  public void push(Artist obj) {
			// if the first is null, then the object in the parameter becomes the tail/lst object in linked list
			if (first == null) {
				first = obj;
				first.next = null;
			}
			// else a temp variable is made to store the object and obj is set to first 
			else {
				Artist temp = obj;
				temp.next = first;
				first = temp;
			}
	  }
	  public void pop() { // removes top object of stack without returning it
		  first = first.next;
	  }
	  public Artist getLastNode() {
			Artist temp = first;
			while (temp.next != null) {
				temp = temp.next;
			}
			return temp;
		}
	  // prints the list
	  public void printList(Artist first) {
			if (first == null) {
				return;
			}
			System.out.println(first.song + " by " + first.name);
			Artist current = first.next;
			printList(current);
	  }
	 
	  public Artist lastListened(){
		  if (first == null) {
			  throw new IllegalArgumentException("List is empty");
		  }
		  // make a temporary object to store first song
		  Artist current = first;

		  // return temp node
		  return current;
	  }
}
