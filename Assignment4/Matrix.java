import java.io.*;
import java.util.*;
public class Matrix {
    int vertex;
    int matrix[][];
    private int Vertex; // No. of vertices
    
    // Array  of lists for 
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Matrix(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
        
        Vertex = vertex;
        adj = new LinkedList[vertex];
        for (int i = 0; i < vertex; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int source, int destination) {
        //add edge
        matrix[source][destination]=1;

        //add back edge for undirected graph
        matrix[destination][source] = 1;
    }
    
    // A function used by DFS
    public void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    
    // The function to do DFS traversal. It uses recursive
    // DFSUtil()
    public void DFS()
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[Vertex];
 
        // Call the recursive helper function to print DFS
        // traversal starting from all vertices one by one
        for (int i = 0; i < Vertex; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }
    
    // prints BFS traversal from a given source s 
    public void BFS(int s) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[Vertex]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 

    public void printGraph() {
    	//Printing the Matrix
        System.out.println("Graph: (Matrix)");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j <vertex ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        
        //Printing the Adjacency List
        System.out.println("Graph: (Adjacency List)");
        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j = 0; j <vertex ; j++) {
                if(matrix[i][j]==1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
       
    }

    public static void main(String[] args) {
    	//Sorry for hard coding this but I couldn't figure out how to use the list to make these,
    	//and I'd rather submit a working assignment that is hard coded with the instructions
    	//than an assignment that doesn't even run but has a list of the instructions.
    	//Yes, it was very tedious, but I think I did it right
    	
    	System.out.println("-- undirected 7-vertex 11-edge tutorial");
        Matrix graph = new Matrix(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.printGraph();
        System.out.println("Following is Depth First Traversal");
        graph.DFS();
        System.out.println("");
        System.out.println("Following is Breadth First Traversal");
        graph.BFS(0);
        
        System.out.println("");
        System.out.println("-- undirected 8-Vertex Full");
        Matrix graph2 = new Matrix(8);
        graph2.addEdge(1, 0);
        graph2.addEdge(2, 0);
        graph2.addEdge(3, 0);
        graph2.addEdge(4, 0);
        graph2.addEdge(5, 0);
        graph2.addEdge(6, 0);
        graph2.addEdge(7, 0);
        graph2.addEdge(2, 1);
        graph2.addEdge(3, 1);
        graph2.addEdge(4, 1);
        graph2.addEdge(5, 1);
        graph2.addEdge(6, 1);
        graph2.addEdge(7, 1);
        graph2.addEdge(3, 2);
        graph2.addEdge(4, 2);
        graph2.addEdge(5, 2);
        graph2.addEdge(6, 2);
        graph2.addEdge(7, 2);
        graph2.addEdge(4, 3);
        graph2.addEdge(5, 3);
        graph2.addEdge(6, 3);
        graph2.addEdge(7, 3);
        graph2.addEdge(5, 4);
        graph2.addEdge(6, 4);
        graph2.addEdge(7, 4);
        graph2.addEdge(6, 5);
        graph2.addEdge(7, 5);
        graph2.addEdge(7, 6);
        graph2.printGraph();
        System.out.println("Following is Depth First Traversal");
        graph2.DFS();
        System.out.println("");
        System.out.println("Following is Breadth First Traversal");
        graph2.BFS(0);
        
        System.out.println("");
        System.out.println("-- undirected 63-Vertex Tree (branch factor = 2)");
        Matrix graph3 = new Matrix(64);
        graph3.addEdge(1, 0);
        graph3.addEdge(2, 0);
        graph3.addEdge(3, 1);
        graph3.addEdge(4, 1);
        graph3.addEdge(5, 2);
        graph3.addEdge(6, 2);
        graph3.addEdge(7, 3);
        graph3.addEdge(8, 3);
        graph3.addEdge(9, 4);
        graph3.addEdge(10, 4);
        graph3.addEdge(11, 5);
        graph3.addEdge(12, 5);
        graph3.addEdge(13, 6);
        graph3.addEdge(14, 6);
        graph3.addEdge(15, 7);
        graph3.addEdge(16, 7);
        graph3.addEdge(17, 8);
        graph3.addEdge(18, 8);
        graph3.addEdge(19, 9);
        graph3.addEdge(20, 9);
        graph3.addEdge(21, 10);
        graph3.addEdge(22, 10);
        graph3.addEdge(23, 11);
        graph3.addEdge(24, 11);
        graph3.addEdge(25, 12);
        graph3.addEdge(26, 12);
        graph3.addEdge(27, 13);
        graph3.addEdge(28, 13);
        graph3.addEdge(29, 14);
        graph3.addEdge(30, 14);
        graph3.addEdge(31, 15);
        graph3.addEdge(32, 15);
        graph3.addEdge(33, 16);
        graph3.addEdge(34, 16);
        graph3.addEdge(35, 17);
        graph3.addEdge(36, 17);
        graph3.addEdge(37, 18);
        graph3.addEdge(38, 18);
        graph3.addEdge(39, 19);
        graph3.addEdge(40, 19);
        graph3.addEdge(41, 20);
        graph3.addEdge(42, 20);
        graph3.addEdge(43, 21);
        graph3.addEdge(44, 21);
        graph3.addEdge(45, 22);
        graph3.addEdge(46, 22);
        graph3.addEdge(47, 23);
        graph3.addEdge(48, 23);
        graph3.addEdge(49, 24);
        graph3.addEdge(50, 24);
        graph3.addEdge(51, 25);
        graph3.addEdge(52, 25);
        graph3.addEdge(53, 26);
        graph3.addEdge(54, 26);
        graph3.addEdge(55, 27);
        graph3.addEdge(56, 27);
        graph3.addEdge(57, 28);
        graph3.addEdge(58, 28);
        graph3.addEdge(59, 29);
        graph3.addEdge(60, 29);
        graph3.addEdge(61, 30);
        graph3.addEdge(62, 30);
        graph3.addEdge(63, 31);
        //graph3.addEdge(64, 31);
        graph3.printGraph();
        System.out.println("Following is Depth First Traversal");
        graph3.DFS();
        System.out.println("");
        System.out.println("Following is Breadth First Traversal");
        graph3.BFS(0);
        
        System.out.println("");
        System.out.println("-- undirected 64-Vertex 72-Edge Erdos-Renyi Random");
        Matrix graph4 = new Matrix(65);
        graph4.addEdge(4, 1);
        graph4.addEdge(10, 0);
        graph4.addEdge(11, 4);
        graph4.addEdge(12, 11);
        graph4.addEdge(13, 2);
        graph4.addEdge(13, 4);
        graph4.addEdge(15, 0);
        graph4.addEdge(16, 5);
        graph4.addEdge(17, 10);
        graph4.addEdge(17, 11);
        graph4.addEdge(19, 1);
        graph4.addEdge(19, 6);
        graph4.addEdge(23, 5);
        graph4.addEdge(27, 25);
        graph4.addEdge(28, 10);
        graph4.addEdge(28, 15);
        graph4.addEdge(29, 9);
        graph4.addEdge(30, 24);
        graph4.addEdge(33, 1);
        graph4.addEdge(34, 1);
        graph4.addEdge(34, 29);
        graph4.addEdge(35, 6);
        graph4.addEdge(35, 29);
        graph4.addEdge(36, 18);
        graph4.addEdge(37, 0);
        graph4.addEdge(37, 4);
        graph4.addEdge(40, 34);
        graph4.addEdge(41, 33);
        graph4.addEdge(41, 37);
        graph4.addEdge(41, 39);
        graph4.addEdge(42, 16);
        graph4.addEdge(42, 25);
        graph4.addEdge(45, 4);
        graph4.addEdge(45, 26);
        graph4.addEdge(45, 27);
        graph4.addEdge(46, 30);
        graph4.addEdge(46, 37);
        graph4.addEdge(47, 1);
        graph4.addEdge(47, 5);
        graph4.addEdge(47, 12);
        graph4.addEdge(47, 25);
        graph4.addEdge(47, 41);
        graph4.addEdge(48, 10);
        graph4.addEdge(48, 18);
        graph4.addEdge(49, 7);
        graph4.addEdge(49, 13);
        graph4.addEdge(49, 26);
        graph4.addEdge(50, 6);
        graph4.addEdge(50, 35);
        graph4.addEdge(51, 1);
        graph4.addEdge(52, 27);
        graph4.addEdge(52, 40);
        graph4.addEdge(53, 3);
        graph4.addEdge(54, 1);
        graph4.addEdge(54, 44);
        graph4.addEdge(56, 48);
        graph4.addEdge(57, 24);
        graph4.addEdge(58, 51);
        graph4.addEdge(59, 22);
        graph4.addEdge(59, 30);
        graph4.addEdge(59, 36);
        graph4.addEdge(59, 39);
        graph4.addEdge(60, 19);
        graph4.addEdge(60, 27);
        graph4.addEdge(60, 30);
        graph4.addEdge(60, 57);
        graph4.addEdge(61, 2);
        graph4.addEdge(61, 3);
        graph4.addEdge(61, 4);
        graph4.addEdge(62, 37);
        graph4.addEdge(63, 39);
        graph4.printGraph();
        System.out.println("Following is Depth First Traversal");
        graph4.DFS();
        System.out.println("");
        System.out.println("Following is Breadth First Traversal");
        graph4.BFS(0);
        
        System.out.println("");
        System.out.println("-- undirected Zork Map (ground level) w/ 3 disconnected components");
        Matrix graph5 = new Matrix(21);
        graph5.addEdge(0, 1);
        graph5.addEdge(0, 3);
        graph5.addEdge(0, 13);
        graph5.addEdge(1, 2);
        graph5.addEdge(1, 14);
        graph5.addEdge(2, 3);
        graph5.addEdge(2, 7);
        graph5.addEdge(3, 12);
        graph5.addEdge(4, 5);
        graph5.addEdge(4, 6);
        graph5.addEdge(7, 8);
        graph5.addEdge(7, 12);
        graph5.addEdge(7, 17);
        graph5.addEdge(8, 12);
        graph5.addEdge(8, 9);
        graph5.addEdge(9, 11);
        graph5.addEdge(10, 11);
        graph5.addEdge(12, 13);
        graph5.addEdge(13, 14);
        graph5.addEdge(13, 15);
        graph5.addEdge(14, 15);
        graph5.addEdge(14, 16);
        graph5.addEdge(15, 17);
        graph5.addEdge(17, 18);
        graph5.addEdge(19, 20);
        graph5.printGraph();
        System.out.println("Following is Depth First Traversal");
        graph5.DFS();
        System.out.println("");
        System.out.println("Following is Breadth First Traversal");
        graph5.BFS(0);
        
    }
}
