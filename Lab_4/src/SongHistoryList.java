
public class SongHistoryList {
	  Artist head;
	  public SongHistoryList(){
		  head = null;
	  }
	  
	  public boolean isEmpty() {
		  return head == null;
	  }
	  public void append(Artist s){
			// if the head is null, then the object in the parameter becomes the tail/last object in linked list
			if (isEmpty()) {
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
	  // prints the list
	  public void printList(Artist head) {
			if (head == null) {
				return;
			}
			System.out.println(head.song + " by " + head.name);
			printList(head.next);
	  }
	 
	  public Artist lastListened(){
		  if (head == null) {
			  throw new IllegalArgumentException("List is empty");
		  }
		  // make a temporary object to store first song
		  Artist current = getLastNode();

		  // return temp node
		  return current;
	  }
}
