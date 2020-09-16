import java.util.*;
public class Queue {
    private ArrayList<String> list = new ArrayList<String>();
    
    public boolean isEmpty() {
    	return list.size() == 0;
    }
    
    public void enqueue(String item) {
    	list.add(item);
    }
    
    public String dequeue() {
    	String item = list.get(1);
    	list.remove(0);
    	return item;
    }
    
    public String peek() {
    	return list.get(0);
    }
    
    
    
}
