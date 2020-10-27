import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
public class Linear {
	
	//private static final String FILE_NAME = "magicitems.txt";
	//private static final int LINES_IN_FILE = 666;
	//private static final int HASH_TABLE_SIZE = 250;
	public static ArrayList<String> smallerList = new ArrayList<String>();
	//ArrayList that will be filled with the 42 strings
	public static int comparisons = 0;
	
	public static ArrayList<String> randomInts(ArrayList<String> list, int desiredSize) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<String> temp = new ArrayList<String>();
		//ArrayList that will be filled with the 42 ints representing the indexes in list
		int j = 0;
		for(int i = 0; i < desiredSize; i++) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(list.size());
			//Get the random ints
			if(ints.size() != 0) {
				if(ints.get(j) == randomIndex) {
					i--;
					continue;
				}
			}
			//If statement is used to prevent repeats
			temp.add(list.get(randomIndex));
			//Add the string to the temp list
		}
		
		linearSearch(list, temp);

		return smallerList;
		
	}
	
	public static ArrayList<String> linearSearch(ArrayList<String> list, ArrayList<String> temp){
		int m = 0;
		while(m <= temp.size()) {
			for(int k = 0; k <= list.size(); k++) {
				comparisons++;
				if(smallerList.size() == 42) {
					//If the new list is at the desired size, we know there are no more values that need to be added
					return smallerList;
					//The new list is now filled with all the selected strings, so we can leave this function
				}
				if(list.get(k).compareToIgnoreCase(temp.get(m)) == 0){
					//If value is found, add it to list
					//If not, continue through for loop
					smallerList.add(list.get(k));
					m++;
					break;
					//Need to break out of the for loop, but stay in the while loop, now looking for the next value
				}
			}
		}
		return smallerList;
		//Removing this line broke the code, even though this return statement is not used
		//I'm assuming it is because the main return is behind an if statement
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hash code tests and analysis.");
		System.out.println("-----------------------------");
		
		//int[] hashValues = new int[LINES_IN_FILE]; 
		
		// Read the contents of FILE_NAME into our array of size LINES_IN_FILE.
		ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\sprag\\eclipse-workspace\\Assignment2\\src\\magicitems.txt")));
		/* 
		 * I tried many times to get this line to work using:
		 * ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("magicitems.txt")));
		 * which you had sent to me in an email with my Assignment2 grade
		 * I could not get it to read my file without declaring the entire path to the file which is specific to my machine
		 * Sorry for this inconvenience
		 */
		
		/*
		 * Testing if list was properly filled
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		*/
		
		
		//Used InsertionSort for my sort
		for(int i=0; i<list.size(); i++) {
			int j=i;
			while(j > 0 && list.get(j).compareToIgnoreCase(list.get(j-1)) < 0) {
				//In the while loop you are checking to see if the value is greater than the one previous to it
				//So we are checking to see if "j" is greater than "j-1"
				String temp = list.get(j);
				list.set(j, list.get(j-1));
				list.set(j-1, temp);
				//Using a temp to switch values in the list
				j--;
				//Need to decrease j to continue testing the previous values
				//The while loop will break if j reaches 0, which is the start of the list
			}
		}
		/*
		for(int y =0; y < list.size(); y++) {
			System.out.println(list.get(y));
		} 
		Printing out the sorted list
		*/
		
		/*
		ArrayList<String> smallerList = new ArrayList<String>();
		//New list for the 42 items
		for(int i = 0; i < 42; i++) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(list.size());
			//Choose the random index from list
			smallerList.add(list.get(randomIndex));
			//Add the string value to new list
			list.remove(randomIndex);
			//Remove from original list to prevent repeats
		}
		*/
		
		//This block of code above was my original way of doing this assignment,
		//but I realized that it was not using a linear search, and even though it is a lot less code,
		//it still works the same
		
		randomInts(list, 42);
		
		///*
		// * Printing out smallerList
		for(int y =0; y < smallerList.size(); y++) {
			System.out.println(smallerList.get(y));
		} 
		System.out.println(smallerList.size());
		//*/
		
		System.out.println("Number of comparisons: " + comparisons);

	}

}