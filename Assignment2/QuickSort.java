import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class QuickSort {

	public static int comparisons = 0;
	
	public static void main(String[] args) throws IOException {
    	ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\sprag\\eclipse-workspace\\Assignment2\\src\\magicitems.txt")));
    	//Copied from Selection Sort
    	/*
    	for(int z =0; z < list.size(); z++) {
    		System.out.println(list.get(z));
    	}
    	//This is just a print function to make sure the file was read properly
    	*/
		
    	QuickSort test = new QuickSort();
    	
    	test.quicksort(list);
    	
    	for(int z =0; z < list.size(); z++) {
    		System.out.println(list.get(z));
    	}
    	
	    System.out.println("Number of Comparisons: " + comparisons);
	    
	}
	
	
	private ArrayList<String> quicksort(ArrayList<String> list){
		//Uses ArrayList<String> as return type
		
		if(list.size() <= 1){
			//List is sorted if there's only 1 value
			return list;
		}
		
		int middle = (int) Math.ceil((double)list.size() / 2);
		String pivot = list.get(middle);
		//Finding the middle value which will be used as the pivot point

		ArrayList<String> less = new ArrayList<String>();
		ArrayList<String> greater = new ArrayList<String>();
		//Creating the two temp arrays
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).compareToIgnoreCase(pivot) > 0){
				comparisons++;
				if(i == middle){
					continue;
					//Once i reaches the middle, end this iteration of the for loop, thereby skipping adding to less
				}
				less.add(list.get(i));
			}
			else{
				comparisons++;
				greater.add(list.get(i));
			}
		}
		
		return concatenate(quicksort(less), pivot, quicksort(greater));
		//concatenate also returns a type ArrayList<String> so it is okay to call the function in the return statement
	}
	
	
	private ArrayList<String> concatenate(ArrayList<String> arrayList, String pivot, ArrayList<String> arrayList2){
		ArrayList<String> list = new ArrayList<String>();
		//This is the ArrayList that will take the correctly sorted inputs
		
		for (int i = 0; i < arrayList.size(); i++) {
			list.add(arrayList.get(i));
			//Adding the values from the ArrayList that holds the first half of the sort
		}
		
		list.add(pivot);
		//Adding the pivot which is after the first half but before the second half
		
		for (int i = 0; i < arrayList2.size(); i++) {
			list.add(arrayList2.get(i));
			//Adding the values from the second ArrayList that holds the second half
		}
		
		return list;
		//Returning the completed list which actually returns twice; here in concatenate and also in quickSort
	}
	
}