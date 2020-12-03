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
  
    // The main function that finds shortest distances from src 
    // to all other vertices using Bellman-Ford algorithm. The 
    // function also detects negative weight cycle 
    public void BellmanFord(Graph graph, int src) { 
        int V = graph.V, E = graph.E; 
        int dist[] = new int[V]; 
  
        // Step 1: Initialize distances from src to all other 
        // vertices as INFINITE 
        for (int i = 0; i < V; ++i) 
            dist[i] = Integer.MAX_VALUE; 
        dist[src] = 0; 
  
        // Step 2: Relax all edges |V| - 1 times. A simple 
        // shortest path from src to any other vertex can 
        // have at-most |V| - 1 edges 
        for (int i = 1; i < V; ++i) { 
            for (int j = 0; j < E; ++j) { 
                int u = graph.edge[j].src; 
                int v = graph.edge[j].dest; 
                int weight = graph.edge[j].weight; 
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
                    dist[v] = dist[u] + weight; 
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
        printArr(dist, V); 
    } 
  
    // A utility function used to print the solution 
    public void printArr(int dist[], int V) { 
    	//For loop has to start at 2 or else it prints out MAX_VALUE for vertex 0 and 0 for vertex 1
        for (int i = 2; i < V; ++i) 
            System.out.println("Vertex: " + i + " cost is " + dist[i]); 
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

	}

}