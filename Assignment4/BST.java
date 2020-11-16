import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class BST {
	
	/* Class containing left  
    and right child of current node 
	 * and key value*/
	class Node  { 
		String key; 
		Node left, right; 

		public Node(String item) 
		{ 
			key = item; 
			left = right = null; 
		} 
	} 

	 // Root of BST 
	public static Node root; 
	
	public static int comparisons = 0;

	// Constructor 
	public BST()  {  
		root = null;  
	} 

	// This method mainly calls insertRec() 
	public void insert(String key)  {  
		root = insertRec(root, key);  
	} 

	/* A recursive function to  
    	insert a new key in BST */
	public Node insertRec(Node root, String key) { 

		/* If the tree is empty, 
        	return a new node */
		if (root == null)  
		{ 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if (key.compareToIgnoreCase(root.key) < 0) 
			root.left = insertRec(root.left, key); 
		else if (key.compareToIgnoreCase(root.key) > 0) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	// This method mainly calls InorderRec() 
	public void inorder()  {  
		inorderRec(root);  
	} 

	// A utility function to  
	// do inorder traversal of BST 
	public void inorderRec(Node root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	} 
	
	// A utility function to search a given key in BST 
	public static Node search(Node root, String string) 
	{ 
		comparisons++;
	    // Base Cases: root is null or key is present at root 
	    if (root==null || root.key==string) {
	        return root; 
	    }
	  
	    comparisons++;
	    // Key is greater than root's key 
	    if (root.key.compareToIgnoreCase(string) < 0) {
	       return search(root.right, string); 
	    }
	  
	    // Key is smaller than root's key 
	    return search(root.left, string); 
	} 

	public static void main(String[] args) throws IOException {
		ArrayList<String> magicitems = new ArrayList<>(Files.readAllLines(Paths.get("magicitems.txt")));
		//Sorry about the previous assignments with the weird reading of the files that I had
		//I don't know why it was so hard for me to figure out, and I probably should have just asked for help
		//I believe this is the correct way that you wanted
		
		BST tree = new BST();
		
		//Adding each magicitem to the BST
		for(int i = 0; i < magicitems.size(); i++) {
			tree.insert(magicitems.get(i));
		}
		
		//Print BST in order of traversal
		tree.inorder();
		
		ArrayList<String> list = new ArrayList<String>();
		//New list for the 42 items
		for(int i = 0; i < 42; i++) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(magicitems.size());
			//Choose the random index from list
			list.add(magicitems.get(randomIndex));
			//Add the string value to new list
			magicitems.remove(randomIndex);
			//Remove from original list to prevent repeats
		}
		
		System.out.println("");
		System.out.println("List of 42 randoms items: ");
		for(int z = 0; z < list.size(); z++) {
			System.out.println(list.get(z));
		}
		
		for(int j = 0; j < list.size(); j++) {
			search(root, list.get(j));
		}
		
		System.out.println("Total number of comparisons: " + comparisons);
		System.out.println("Average number of comparisons: " + comparisons/42);
	}

}
