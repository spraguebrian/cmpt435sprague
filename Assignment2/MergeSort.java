import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MergeSort {
	
	public static int comparisons = 0;
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\sprag\\eclipse-workspace\\Assignment2\\src\\magicitems.txt")));
		//Copied from SelectionSort because that was the first one I did
		/*
		for(int z =0; z < list.size(); z++) {
			System.out.println(list.get(z));
		}
		This is just a print function to make sure the file was read properly
		*/
		MergeSort object = new MergeSort();
		object.sort(list,  0,  list.size() - 1);
		
		printArray(list);
		System.out.println("Number of Comparisons: " + comparisons);
	}
	
	void sort(ArrayList<String> list, int left, int right) { 
		//When calling this function you use your array, 0(the left value), and list.size() (the right value)
		/*
		for(int z =0; z < list.size(); z++) {
			System.out.println(list.get(z));
		}
		//Testing if list is read in
		*/
		//System.out.println("sort: Left: " + left);
		//System.out.println("sort: Right: " + right);
		//I had a problem with indexing 0 so these print statements
		//are used to check where it went wrong
		if(left < right) {
			int middle = right / 2;
			//This is used to find the midpoint, it will be rounded if the length is odd
			//System.out.println("sort: middle: " + middle);
			
			sort(list, left, middle);
			sort(list, middle+1, right);
			//Need to continue splitting until the arrays are size 1, middle+1 is needed so we don't repeat values
			//System.out.println("sort: Left: " + left);
			//System.out.println("sort: Right: " + right);
			//System.out.println("sort: middle: " + middle);
			merge(list, left, middle, right);
		}
	}
	
	void merge(ArrayList<String> list, int left, int middle, int right) {
		int size1 = middle - left + 1;
		int size2 = right-middle;
		
		//Finding sizes of both arrays
		System.out.println("merge: Left: " + left);
		System.out.println("merge: Middle: " + middle);
		System.out.println("merge: Right: " + right);
		System.out.println("merge: Size 1: " + size1);
		System.out.println("merge: Size 2: " + size2);
		ArrayList<String> leftArr = new ArrayList<String>();
		ArrayList<String> rightArr = new ArrayList<String>();
		//Creating the temp arrays
		
		for(int i=0; i<size1; i++) {
			leftArr.set(i, list.get(left+i));
		}
		for(int j = 0; j<size2; j++) {
			rightArr.set(j, list.get(middle + 1 + j));
		}
		//Filling the temp arrays
		
		int i=0;
		int j=0;
		//Indexes for both temp arrays
		
		int k = left;
		while(i<size1 && j<size2) {
			if(leftArr.get(i).compareToIgnoreCase(rightArr.get(j)) > 0) {
				//Checking for the correct order alphabetically
				list.set(k, leftArr.get(i));
				i++;
				comparisons++;
				//Assigning the correct word to the main array and increasing the index
			}
			else {
				list.set(k, rightArr.get(j));
				j++;
				comparisons++;
				//Same logic
			}
			k++;
			//Increasing the index of main array
		}
		
		while(i<size1) {
			list.set(k, leftArr.get(i));
			i++;
			k++;
		}
		
		while(j<size2) {
			list.set(k, rightArr.get(j));
			j++;
			k++;
		}
	}
	
	static void printArray(ArrayList<String> list) {
		for(int x = 0; x < list.size(); x++) {
			System.out.println(list.get(x));
		}
	}

}
