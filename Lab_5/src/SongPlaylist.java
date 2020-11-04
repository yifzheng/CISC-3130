
public class SongPlaylist {
	
	public Song root; // root node of BST
	
	public SongPlaylist() {
		
		root = null;
		
	}
	// returns whether BST is empty
	public boolean isEmpty() {
		
		return root == null;
		
	}
	
	//adds objects into BST;
	public void insert(Song obj) {
		
		if (root == null) {
			
			root = obj;
		}
		else {
			
			Song current = root;
			
			Song parent;
			
			while (true) {
				
				parent = current;
				// if the objet's songtitle eqauals the current nodes song title, reset average stream for the song
				if (obj.songTitle.compareToIgnoreCase(current.songTitle) == 0) {
					current.setArtistAverage(obj);
					return;
				}
				else if (obj.songTitle.compareToIgnoreCase(current.songTitle) < 0) {
					
					current = current.left;
					
					if (current == null) {
						
						parent.left = obj;
						return;
						
					}
				}
				else {
					current = current.right;
					
					if (current == null) {
						
						parent.right = obj;
						return;
						
					}
				}
			}
		}
	}
	
	
	// inorder transversal of BST
	public void inorderTransversal() {
		
		inorder(root);
		
	}
	// helper function or can be used to in order transversal for any subtree of BST
	public void inorder(Song root) {
		
		if (root == null) {
			
			return;
			
		}
		
		inorder(root.left); // transverses left of root
		
		System.out.println(root); // prints root
		
		inorder(root.right); // transverses right of root
	}
	
	//subset function is made to print out songs within range of two values in argument. ex. subset("jingle bells", "merry christmas") only prints songs alphabetically between 
	// jingle bells and merry christmas
	public void subset(String song1, String song2) {
		subset(root, song1, song2); // calls helper function with root as one of the arguments
	}
	public Song subset(Song root, String song1, String song2) { // takes in three arguments
	
		if (root == null) {
			return root;
		}
		
		Song current = root;
		
		if (song1.compareTo(current.songTitle) < 0) {
			subset(current.left, song1, song2);
		}
		if ((song1.compareTo(current.songTitle) <= 0) && (song2.compareTo(current.songTitle) >= 0)) {
			System.out.println(current);
		}
		if (song2.compareTo(current.songTitle) > 0) {
			subset(current.right, song1, song2);
		}
		return root;
	}
}
