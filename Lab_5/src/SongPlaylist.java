import java.util.ArrayList;

public class SongPlaylist {
	ArrayList<Song> branch = new ArrayList<>(); // arraylist to store the subtree values for output file
	ArrayList<Song> BST = new ArrayList<>();// arraylist to store BST values for output file.
	public Song root; // root node of BST
	// constructor for class
	public SongPlaylist() {

		root = null;

	}

	// returns whether BST is empty
	public boolean isEmpty() {

		return root == null;

	}

	// adds objects into BST;
	public void insert(Song obj) {
		// if the root is null, the BST is empty so the object becomes the root of the BST
		if (root == null) {

			root = obj;
		} else {
			// set current to root
			Song current = root;
			// helper object
			Song parent;

			while (true) {
				// parent equals current as a pivot for declaring children later on in the code
				parent = current;
				// if the objet's songtitle eqauals the current nodes song title, reset average
				// stream for the song
				if (obj.songTitle.compareToIgnoreCase(current.songTitle) == 0) {
					current.setArtistAverage(obj);
					return;
					// if the objects song title comapred to the current.songTitle is less
				} else if (obj.songTitle.compareToIgnoreCase(current.songTitle) < 0) {
					// head to left side of tree
					current = current.left;
					// if we've reached the leaf node we set the parent.left equal to the object
					if (current == null) {

						parent.left = obj;
						return;

					}
					// same process as in lines 42-51 but on the right side
				} else {
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
	public void inorderTranversal() {
		//calls helper function
		inorder(root);

	}

	// helper function or can be used to in order transversal for any subtree of BST
	public void inorder(Song root) {
		// if the root is null return
		if (root == null) {

			return;

		}
		// recursivley calls the left side of the tree
		inorder(root.left); // transverses left of root
		//adds the root to the list
		BST.add(root);
		// prints out the root
		System.out.println(root); // prints root
		// recursively calls the right side of the root
		inorder(root.right); // transverses right of root
	}

	// subset function is made to print out songs within range of two values in
	// argument. ex. subset("jingle bells", "merry christmas") only prints songs
	// alphabetically between
	// jingle bells and merry christmas
	public Song subset(String song1, String song2) {
		return subset(root, song1, song2); // calls helper function with root as one of the arguments
	}

	public Song subset(Song root, String song1, String song2) { // takes in three arguments
		// if root is null returns to previous call 
		if (root == null) {
			return root;
		}
		// if the song title is less alphabetically call left of root
		if (song1.compareToIgnoreCase(root.songTitle) < 0) {
			subset(root.left, song1, song2);
		}
		// if it is within the range add to the branch list and prints out the root
		if ((song1.compareToIgnoreCase(root.songTitle) <= 0) && (song2.compareToIgnoreCase(root.songTitle) >= 0)) {
			branch.add(root);
			System.out.println(root);
		}
		// if greater call right side of root.
		if (song2.compareToIgnoreCase(root.songTitle) > 0) {
			subset(root.right, song1, song2);
		}
		//returns root of the BST
		return root;
	}
}
