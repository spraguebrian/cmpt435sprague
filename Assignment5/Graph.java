import java.io.*;
import java.lang.*; 
import java.util.*;
class Graph { 
    // A class to represent a weighted edge in graph 
    class Edge { 
        int src, dest, weight; 
        Edge() { 
            src = dest = weight = 0; 
        } 
    }; 
  
    int V, E; 
    Edge edge[]; 
  
    // Creates a graph with V vertices and E edges 
    Graph(int v, int e) { 
        V = v; 
        E = e; 
        edge = new Edge[e]; 
        for (int i = 0; i < e; ++i) 
            edge[i] = new Edge(); 
    } 
    
    // Recursive Function to print path of given vertex from source vertex
    static void printPath(int parent[], int vertex)
    {
        if (vertex < 0)
            return;
 
        printPath(parent, parent[vertex]);
        System.out.print(vertex + " ");
    }

  
    // The main function that finds shortest distances from src 
    // to all other vertices using Bellman-Ford algorithm. The 
    // function also detects negative weight cycle 
    public void BellmanFord(Graph graph, int src) { 
        int V = graph.V, E = graph.E; 
        int dist[] = new int[V]; 
        int parent[] = new int[V];
  
        // Step 1: Initialize distances from src to all other 
        // vertices as INFINITE 
        for (int i = 0; i < V; ++i) 
            dist[i] = Integer.MAX_VALUE; 
        dist[src] = 0; 
        
        for (int i = 0; i < V; ++i)
        	parent[i] = -1; 
  
        // Step 2: Relax all edges |V| - 1 times. A simple 
        // shortest path from src to any other vertex can 
        // have at-most |V| - 1 edges 
        for (int i = 1; i < V; ++i) { 
            for (int j = 0; j < E; ++j) { 
                int u = graph.edge[j].src; 
                int v = graph.edge[j].dest; 
                int weight = graph.edge[j].weight; 
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
                    dist[v] = dist[u] + weight; 
                    parent[v] = u;
                }
            } 
        } 
  
        // Step 3: check for negative-weight cycles. The above 
        // step guarantees shortest distances if graph doesn't 
        // contain negative weight cycle. If we get a shorter 
        // path, then there is a cycle. 
        for (int j = 0; j < E; ++j) { 
            int u = graph.edge[j].src; 
            int v = graph.edge[j].dest; 
            int weight = graph.edge[j].weight; 
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
                System.out.println("Graph contains negative weight cycle"); 
                return; 
            } 
        } 
        
      //For loop has to start at 2 or else it prints out MAX_VALUE for vertex 0 and 0 for vertex 1
        for (int i = 2; i < V; ++i) {
            System.out.println("-- 1 --> " + i + " cost is " + dist[i] + "; path: " ); 
        	printPath(parent, i);
        	System.out.println("");
        }
    } 
  
    // A utility function used to print the solution 
    public void printArr(int dist[], int V) { 
    	
        
    } 
    
	public static void main(String[] args) {
		System.out.println("-- CLRS and class example ");
		Graph graph1 = new Graph(6, 10);
		graph1.edge[0].src = 2;
		graph1.edge[0].dest = 3;
		graph1.edge[0].weight = 5;
		graph1.edge[1].src = 2;
		graph1.edge[1].dest = 4;
		graph1.edge[1].weight = 8;
		graph1.edge[2].src = 2;
		graph1.edge[2].dest = 5;
		graph1.edge[2].weight = -4;
		graph1.edge[3].src = 3;
		graph1.edge[3].dest = 2;
		graph1.edge[3].weight = -2;
		graph1.edge[4].src = 4;
		graph1.edge[4].dest = 3;
		graph1.edge[4].weight = -3;
		graph1.edge[5].src = 4;
		graph1.edge[5].dest = 5;
		graph1.edge[5].weight = 9;
		graph1.edge[6].src = 5;
		graph1.edge[6].dest = 3;
		graph1.edge[6].weight = 7;
		graph1.edge[7].src = 5;
		graph1.edge[7].dest = 1;
		graph1.edge[7].weight = 2;
		graph1.edge[8].src = 1;
		graph1.edge[8].dest = 2;
		graph1.edge[8].weight =6;
		graph1.edge[9].src = 1;
		graph1.edge[9].dest = 4;
		graph1.edge[9].weight = 7;
		graph1.BellmanFord(graph1, 1);
		System.out.println("");
		
		System.out.println("-- directed 7-vertex v1 -- the \"Tyler\" graph.");
		Graph graph2 = new Graph(8, 12);
		graph2.edge[0].src = 1;
		graph2.edge[0].dest = 2;
		graph2.edge[0].weight = 0;
		graph2.edge[1].src = 1;
		graph2.edge[1].dest = 5;
		graph2.edge[1].weight = 0;
		graph2.edge[2].src = 1;
		graph2.edge[2].dest = 6;
		graph2.edge[2].weight = 0;
		graph2.edge[3].src = 2;
		graph2.edge[3].dest = 3;
		graph2.edge[3].weight = 0;
		graph2.edge[4].src = 2;
		graph2.edge[4].dest = 5;
		graph2.edge[4].weight = 0;
		graph2.edge[5].src = 2;
		graph2.edge[5].dest = 6;
		graph2.edge[5].weight = 0;
		graph2.edge[6].src = 3;
		graph2.edge[6].dest = 4;
		graph2.edge[6].weight = 0;
		graph2.edge[7].src = 4;
		graph2.edge[7].dest = 5;
		graph2.edge[7].weight = 0;
		graph2.edge[8].src = 5;
		graph2.edge[8].dest = 3;
		graph2.edge[8].weight = 0;
		graph2.edge[9].src = 5;
		graph2.edge[9].dest = 6;
		graph2.edge[9].weight = 0;
		graph2.edge[10].src = 5;
		graph2.edge[10].dest = 7;
		graph2.edge[10].weight = 0;
		graph2.edge[11].src = 6;
		graph2.edge[11].dest = 7;
		graph2.edge[11].weight = 0;
		graph2.BellmanFord(graph2, 1);
		System.out.println("");
		
		System.out.println("-- directed 7-vertex v2");
		Graph graph3 = new Graph(8, 12);
		graph3.edge[0].src = 1;
		graph3.edge[0].dest = 2;
		graph3.edge[0].weight = 1;
		graph3.edge[1].src = 1;
		graph3.edge[1].dest = 5;
		graph3.edge[1].weight = 1;
		graph3.edge[2].src = 1;
		graph3.edge[2].dest = 6;
		graph3.edge[2].weight = 1;
		graph3.edge[3].src = 2;
		graph3.edge[3].dest = 3;
		graph3.edge[3].weight = 1;
		graph3.edge[4].src = 2;
		graph3.edge[4].dest = 5;
		graph3.edge[4].weight = 1;
		graph3.edge[5].src = 2;
		graph3.edge[5].dest = 6;
		graph3.edge[5].weight = 1;
		graph3.edge[6].src = 3;
		graph3.edge[6].dest = 4;
		graph3.edge[6].weight = 1;
		graph3.edge[7].src = 4;
		graph3.edge[7].dest = 5;
		graph3.edge[7].weight = 1;
		graph3.edge[8].src = 5;
		graph3.edge[8].dest = 3;
		graph3.edge[8].weight = 1;
		graph3.edge[9].src = 5;
		graph3.edge[9].dest = 6;
		graph3.edge[9].weight = 1;
		graph3.edge[10].src = 5;
		graph3.edge[10].dest = 7;
		graph3.edge[10].weight = 1;
		graph3.edge[11].src = 6;
		graph3.edge[11].dest = 7;
		graph3.edge[11].weight = 1;
		graph3.BellmanFord(graph3, 1);
		System.out.println("");
		
		System.out.println("-- directed 7-vertex v3");
		Graph graph4 = new Graph(8, 12);
		graph4.edge[0].src = 1;
		graph4.edge[0].dest = 2;
		graph4.edge[0].weight = 2;
		graph4.edge[1].src = 1;
		graph4.edge[1].dest = 5;
		graph4.edge[1].weight = 3;
		graph4.edge[2].src = 1;
		graph4.edge[2].dest = 6;
		graph4.edge[2].weight = 3;
		graph4.edge[3].src = 2;
		graph4.edge[3].dest = 3;
		graph4.edge[3].weight = 7;
		graph4.edge[4].src = 2;
		graph4.edge[4].dest = 5;
		graph4.edge[4].weight = -1;
		graph4.edge[5].src = 2;
		graph4.edge[5].dest = 6;
		graph4.edge[5].weight = 1;
		graph4.edge[6].src = 3;
		graph4.edge[6].dest = 4;
		graph4.edge[6].weight = 1;
		graph4.edge[7].src = 4;
		graph4.edge[7].dest = 5;
		graph4.edge[7].weight = -2;
		graph4.edge[8].src = 5;
		graph4.edge[8].dest = 3;
		graph4.edge[8].weight = 5;
		graph4.edge[9].src = 5;
		graph4.edge[9].dest = 6;
		graph4.edge[9].weight = 3;
		graph4.edge[10].src = 5;
		graph4.edge[10].dest = 7;
		graph4.edge[10].weight = 1;
		graph4.edge[11].src = 6;
		graph4.edge[11].dest = 7;
		graph4.edge[11].weight = 14;
		graph4.BellmanFord(graph4, 1);
	}
}
