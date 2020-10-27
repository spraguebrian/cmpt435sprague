import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Binary {

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
		
		binarySearch(list, temp);
		
		return smallerList;
		
	}
	
	public static ArrayList<String> binarySearch(ArrayList<String> list, ArrayList<String> temp){
		int index = 0;
		
		while(index < temp.size()) {
			int left = 0;
			int right = list.size() - 1;
			while(left <= right) {
				int mid = left + (right - left) /2;
				
				if(smallerList.size() == 42) {
					return smallerList;
				}
				
				comparisons++;
				if(list.get(mid).compareToIgnoreCase(temp.get(index)) == 0) {
					//If value is found, add it to list
					//If not, continue through for loop
					smallerList.add(list.get(mid));
					break;
				}
				
				else if(list.get(mid).compareToIgnoreCase(temp.get(index)) < 0) {
					left = mid + 1;
				}
				
				else if(list.get(mid).compareToIgnoreCase(temp.get(index)) > 0) {
					right = mid - 1;
				}
			}
			
			index++;
		}
		
		return smallerList;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hash code tests and analysis.");
		System.out.println("-----------------------------");
		
		ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\sprag\\eclipse-workspace\\Assignment2\\src\\magicitems.txt")));
		/* 
		 * I tried many times to get this line to work using:
		 * ArrayList<String> list = new ArrayList<>(Files.readAllLines(Paths.get("magicitems.txt")));
		 * which you had sent to me in an email with my Assignment2 grade
		 * I could not get it to read my file without declaring the entire path to the file which is specific to my machine
		 * Sorry for this inconvenience
		 */
		
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

