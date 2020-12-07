import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
public class sim {
	
	public static int case1 = 0;
	public static int case2 = 0;
	public static int case3 = 0;
	
	public static void main(String args[]) {
		int size = 0;
		//Have the user input a number for the population size
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number for population size (1000): ");
		size = sc.nextInt();
		//That number will be used to set the array size
		ArrayList<Integer> list = new ArrayList<Integer>();
		int array[] = new int[size];
		//The temp array will be used to hold every case at the start
		//x number of positives and negatives
		//and then I will use Random to randomly select them 1 at a time
		//to add to the main array
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int numPos = (int) (size * .02);
		for(int i = 0; i < numPos; i++) {
			temp.add(1);
		}
		for(int j = numPos; j < size; j++) {
			temp.add(0);
		}
		
		//For loop to randomly select a case and add it to the main array
		for(int k = 0; k < size; k++) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(temp.size());
			//Choose the random index from temp
			list.add(temp.get(randomIndex));
			//Add the string value to main array
			temp.remove(randomIndex);
			//Remove from temp to prevent repeats
		}
		
		//variable used to parse through list
		int m = 0;
		//While loop to go through the entire array
		while(m < list.size()){
			//Temp list that is used to hold the 8 test cases at a time
			ArrayList<Integer> test = new ArrayList<Integer>();
			for(int n = 0; n < 8; n++) {
				test.add(list.get(n));
			}
			
			//Remove those 8 from list
			for(int p = 0; p < 8; p++) {
				list.remove(0);
			}
			
			//Parse through test array and see number of positives
			int posCases = 0;
			for(int o = 0; o < test.size(); o++) {
				if(test.get(o) == 1) {
					posCases++;
				}
			}
			
			//Check the number of positives to see what Case we have
			if(posCases == 0) {
				case1++;
			}
			else if(posCases == 1) {
				case2++;
			}
			else {
				case3++;
			}
		}
		
		System.out.println("Case1: " + case1);
		System.out.println("Case2: " + case2);
		System.out.println("Case3: " + case3);
		
	}

}
