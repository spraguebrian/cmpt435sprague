
public class Stack{
	private class Node{
		String data;
		Node link;
	}
	Node top;
	public static boolean emptyList;
	
	public boolean isEmpty() {
		return top == null;
	}
	public void push(String x) {
		Node temp = new Node();
		if(temp == null) {
			System.out.println("Overflow");
		}
		temp.data = x;
		temp.link = top;
		top = temp;
	}
	public String pop() {
		if(top == null) {
			System.out.println("Underflow");
		}
		top = (top).link;
		return top.data;
		
	}

}
