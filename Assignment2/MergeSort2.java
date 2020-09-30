import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class MergeSort2 {
 
    private ArrayList<String> strList;
    public static int comparisons = 0;
 
    //Constructor
    public MergeSort2(ArrayList<String> list) {
        strList = list;
    }
     
    public void sort() {
        strList = mergeSort(strList);
        //Sort functions just calls the mergeSort function
    }
 
    public ArrayList<String> mergeSort(ArrayList<String> whole) {
    	//Uses ArrayList of type String as the expected return value
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();
        //Creates the 2 temp arrays
        int center;
 
        if (whole.size() == 1) {    
            return whole;
        } else {
            center = whole.size()/2;
            //Copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                    left.add(whole.get(i));
            }
 
            //Copy the right half of whole into the new arraylist.
            for (int j=center; j<whole.size(); j++) {
                    right.add(whole.get(j));
            }
 
            //Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);
 
            //Merge the results back together.
            merge(left, right, whole);
        }
        return whole;
    }
 
    private void merge(ArrayList<String> left, ArrayList<String> right, ArrayList<String> whole) {
    	//merge function is responsible for combining the 2 temp arrays into the whole array
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        while (leftIndex < left.size() && rightIndex < right.size()) {
        	//In here it checks to see which arraylist a word should be taken out of
            if ( (left.get(leftIndex).compareToIgnoreCase(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
                comparisons++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
                comparisons++;
            }
            wholeIndex++;
        }
 
        ArrayList<String> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            //The left ArrayList is done
            rest = right;
            restIndex = rightIndex;
        } else {
            //The right ArrayList is done
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
 
    public void print() {
        System.out.println("Sorted:");
        for (int i=0; i< strList.size();i++) {
            System.out.println(strList.get(i));
        }
    }
 
    	
    public static void main(String[] args) throws IOException {
    	ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\sprag\\eclipse-workspace\\Assignment2\\src\\magicitems.txt")));
    	//Copied from SelectionSort because that was the first one I did
    	/*
    	for(int z =0; z < list.size(); z++) {
    		System.out.println(list.get(z));
    	}
    	This is just a print function to make sure the file was read properly
    	*/
       MergeSort2 test = new MergeSort2(list);
       test.sort();
       test.print();
       System.out.println("Number of Comparisons: " + comparisons);
   }
}