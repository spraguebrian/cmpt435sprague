import java.io.*;
public class Assignment1 {
	
	
	public static void main(String[] args) throws Exception{
		String[] list = new String[666];
		Stack myStack = new Stack();
		Queue myQueue = new Queue();
		File file = new File("C:\\Users\\sprag\\OneDrive\\Documents\\downloads\\magicitems.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
		    int k=0;
		    list[k] = st;
		    k++;
		    System.out.println(st);
		  }
		  
		  
		  int compare = 0;
		  for(int i=0; i<666; i++) {
			  for(int j = 0; j<list[i].length();j++) {
				  list[i].toLowerCase();
				  list[i].trim();
				  myQueue.enqueue(list[i]);
				  myStack.push(list[i]);
				  String queueTemp = myQueue.dequeue();
				  String stackTemp = myStack.pop();
				  compare = queueTemp.compareTo(stackTemp);
				  if(compare != 0) {
					  break;
				  }
				  if(compare == 0) {
					  System.out.println(list[i] + " is a pallindrome.");
				  }
				  
			  }
			
		  }
		  

	}

}
