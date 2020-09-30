import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
class QuickSort3{
		public static int comparisons = 0;
		public int partition(ArrayList<String> list, int lowIndex, int highIndex){
			String pivot = list.get(highIndex);
			//Creating the pivot
			int i = (lowIndex-1);
			//i is used to keep track of place in list
			for (int j=lowIndex; j<highIndex; j++){
				//Only want to work in between the low point and the high point (lowIndex and highIndex)
				if (list.get(j).compareToIgnoreCase(pivot)<=0){
					comparisons++;
					i++;
					String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
					//Setting the sorted strings in the list
				}
			}
			String temp = list.get(i+1);
			list.set(i+1, list.get(highIndex));
			list.set(highIndex, temp);
			//temp variable is used for setting the string in the correct place without losing it
			return i+1;
		}

		public void sort(ArrayList<String> list, int lowIndex, int highIndex){
			if (lowIndex < highIndex){
				//Only need to do this if lowIndex is less than highIndex, would be done if that was false
				int pi = partition(list, lowIndex, highIndex);
				sort(list, lowIndex, pi-1);
				sort(list, pi+1, highIndex);
				//Here is the recursive portion of the function
			}
		}

		public static void printArray(ArrayList<String> list){
			int n = list.size();
			for (int i=0; i<n; ++i)
				System.out.print(list.get(i)+"\n");
				//Printing out each individual string on its own line
			System.out.println();
			//Creates a blank line between list and comparison number
		}

		public static void main(String args[]) throws IOException{
			ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\sprag\\eclipse-workspace\\Assignment2\\src\\magicitems.txt")));
        	//Copied from Selection Sort
        	/*
        	for(int z =0; z < list.size(); z++) {
        		System.out.println(list.get(z));
        	}
        	//This is just a print function to make sure the file was read properly
        	*/
			int n = list.size();
			QuickSort3 ob = new QuickSort3();
			ob.sort(list, 0, n-1);
			System.out.println("Sorted List");
			printArray(list);
			System.out.println("Number of Comparisons: "+comparisons);
		}
}