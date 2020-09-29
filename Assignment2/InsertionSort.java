import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InsertionSort {

	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\sprag\\eclipse-workspace\\Assignment2\\src\\magicitems.txt")));
		//Copied from SelectionSort because that was the first one I did
		/*
		for(int z =0; z < list.size(); z++) {
			System.out.println(list.get(z));
		}
		This is just a print function to make sure the file was read properly
		*/
		
		int comparisons = 0;
		
		for(int i=0; i<list.size(); i++) {
			int j=i;
			while(j > 0 && list.get(j).compareToIgnoreCase(list.get(j-1)) < 0) {
				//In the while loop you are checking to see if the value is greater than the one previous to it
				//So we are checking to see if "j" is greater than "j-1"
				String temp = list.get(j);
				list.set(j, list.get(j-1));
				list.set(j-1, temp);
				//Using a temp to switch values in the list
				comparisons++;
				j--;
				//Need to decrease j to continue testing the previous values
				//The while loop will break if j reaches 0, which is the start of the list
			}
		}
		for(int y =0; y < list.size(); y++) {
			System.out.println(list.get(y));
		} //Printing out the sorted list
		System.out.println("Number of Comparisons: " + comparisons);
		
	}

}
