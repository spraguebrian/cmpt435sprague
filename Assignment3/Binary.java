import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Binary {

	//private static final String FILE_NAME = "magicitems.txt";
	private static final int LINES_IN_FILE = 666;
	private static final int HASH_TABLE_SIZE = 250;
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
	
	private static int makeHashCode(String str) {
		str = str.toUpperCase();
		int length = str.length();
		int letterTotal = 0;
		// Iterate over all letters in the string, totalling their ASCII values.
		for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int)thisLetter;
            letterTotal = letterTotal + thisValue;   
            // Test: print the char and the hash.
            /* 
            System.out.print(" ["); 
            System.out.print(thisLetter); 
            System.out.print(thisValue); 
            System.out.print("] "); 
            // */
        }   
		// Scale letterTotal to fit in HASH_TABLE_SIZE.
		int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
		// TODO: Experiment with letterTotal * 2, 3, 5, 50, etc. 
		return hashCode;
		}
	
	private static void analyzeHashValues(int[] hashValues) {
		System.out.println("\nHash Table Usage:");
		// Sort the hash values.
		Arrays.sort(hashValues);  // This is a "dual-pivot" quicksort.
   
		// Test: print the sorted hash values.
		/* 
		for (int i=0; i < LINES_IN_FILE; i++) { 
            System.out.println(hashValues[i]); 
		} 
		// */
   
		// Create a histogram-like report based on the count of each unique hash value,
		// count the individual entry size,
		// the total space used (in items),
		// and the standard deviation of their distribution over the hash table.
		int asteriskCount = 0;
		int[] bucketCount = new int[HASH_TABLE_SIZE];
		int totalCount = 0;
		int arrayIndex = 0;
   
		for (int i=0; i < HASH_TABLE_SIZE; i++) {
            System.out.format("%03d ", i);
            asteriskCount = 0;
            while ( (arrayIndex < LINES_IN_FILE) && (hashValues[arrayIndex] == i) ) {
               System.out.print("*");
               asteriskCount = asteriskCount + 1;
               arrayIndex = arrayIndex + 1;
            }
            System.out.print(" ");
            System.out.println(asteriskCount);
            bucketCount[i] = asteriskCount;
            totalCount = totalCount + asteriskCount;
         }
   
         System.out.print("Average load (count): ");
         float averageLoad = (float) totalCount / HASH_TABLE_SIZE;
         System.out.format("%.2f%n", averageLoad);
   
         System.out.print("Average load (calc) : ");
         averageLoad = (float) LINES_IN_FILE / HASH_TABLE_SIZE;
         System.out.format("%.2f%n", averageLoad);
   
         System.out.print("Standard Deviation: ");
         // TODO: Refactor this into its own method.
         double sum = 0;
         for (int i=0; i < HASH_TABLE_SIZE; i++) {
            // For each value in the array...
            // ... subtract the mean from each one ...
            double result = bucketCount[i] - averageLoad;
            // ... and square the result.
           double square = result * result;
           // Sum all of those squares.
           sum = sum + square;
        }
        // Divide the sum by the number of values ...
        double temp = sum / HASH_TABLE_SIZE;
        // ... and take the square root of that.
        double stdDev = Math.sqrt(temp);
        System.out.format("%.2f%n", stdDev);
     }
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hash code tests and analysis.");
		System.out.println("-----------------------------");
		
		int[] hashValues = new int[LINES_IN_FILE];
		
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
		
		System.out.println("Number of total comparisons: " + comparisons);
		System.out.println("Average number of comparisons: " + comparisons/42);
		
		int hashCode = 0;
		for(int i = 0; i<LINES_IN_FILE; i++) {
			System.out.print(i);
			System.out.print(". " + list.get(i) + " - ");
			hashCode = makeHashCode(list.get(i));
			System.out.format("%03d%n",  hashCode);
		}
		
		// Analyze the distribution of hash values.
		analyzeHashValues(hashValues);

	}

}

