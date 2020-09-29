import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SelectionSort {

	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\sprag\\eclipse-workspace\\Assignment2\\src\\magicitems.txt")));
		/*
		Sorry for hard coding the file from my laptop, but I've spent hours trying to get it to work
		the other way but this is the only way I've gotten it to output anything.
		On Assignment1 I got a large number of points off due to a runtime error, so I hope that this way is acceptable
		*/
		
		/*
		for(int z =0; z < list.size(); z++) {
			System.out.println(list.get(z));
		}
		This is just a print function to make sure the file was read properly
		*/
		int minPlace; //Shows the lowest int value in list
		String minVal; //Shows the lowest String value in list
		int comparisons = 0; //Keeps track of number of comparisons
		
		for(int i=0; i< list.size(); i++) {
			minPlace = i;
			minVal = list.get(i);
			for(int j = i+1; j<list.size(); j++) {
				if(list.get(i).compareToIgnoreCase(list.get(j)) > 0) {
					comparisons++;
					minVal = list.get(j);
					minPlace = j;
				}
			}
			list.set(minPlace,  list.get(i));
			list.set(i, minVal);
			//Swapping the current place in the list with the lowest string alphabetically
		}
		
		for(int y =0; y < list.size(); y++) {
			System.out.println(list.get(y));
		} //Printing out the sorted list
		
		
		System.out.println("Number of Comparisons: " + comparisons);
	}

}
