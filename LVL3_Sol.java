package lvl3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public static int solution(int[][] map) {
        // Your code here
    	int row = map[0].length;
    	int column = map.length;
    	int V = (row * column);
    	int[][] mapClone = map.clone();
    	int cloneAns;
		int ans = 	getShortestPath(map);
   
		
	    for(int i=0 ;i<row;i++) {
		    for(int j=0 ;j<column;j++) {
		    	
		    	if(mapClone[i][j]==0) {
		    		continue;
		    	}
		    	
		    	mapClone[i][j]=0;
		    	cloneAns = getShortestPath(mapClone);
		    	if(cloneAns<ans) {
		    		ans = cloneAns;
		    	}
		    }
	    }
		
			
			return ans;
			
		}
    
    public static int getShortestPath(int[][] map) {
    	int row = map[0].length;
    	int column = map.length;
    	int V = (row * column);
    	

			int source = 0; 

			// Adjacency list representation of the 
			// connected edges 
			List<List<Node> > adj = new ArrayList<List<Node> >(); 

			// Initialize list for every node 
			for (int i = 0; i < V; i++) { 
				List<Node> item = new ArrayList<Node>(); 
				adj.add(item); 
			} 

			// Inputs for the DPQ graph 
			
			
			
			for (int i = 0; i < V; i++) {
				
				int value = i / row;
				int pos = i - (row*value);
				
				if(i>=row) {
					adj.get(i).add(new Node(i-row, getWeight(i-row,map))); 
				}
				
				if(i<V-row) {
					adj.get(i).add(new Node(i+row, getWeight(i+row,map)));
				}
				if(pos>0) {
					adj.get(i).add(new Node(i-1, getWeight(i-1,map)));
				}				
				if(pos<(row-1)) {
					adj.get(i).add(new Node(i+1, getWeight(i+1,map)));
				}				
				
			} 
			
			
			// Calculate the single source shortest path 
			DPQ dpq = new DPQ(V); 
			dpq.dijkstra(adj, source); 
			
			int ans = dpq.dist[V-1];		
			
			if (ans>V) {
				ans= ans - V;
			}
			
			ans +=1;
			
			return ans;
    	
    }

	public static int getWeight(int i, int[][] map) {
		// TODO Auto-generated method stub
    	int row = map[0].length;
    	int column = map.length;
    	int V = row * column;
    	
    	if(i==V) {
    		return 1;
    	}
    	
		int value = (i / row);
		int pos = i - (row*value);
		int weight =map[value][pos];
		
	/*	System.out.println("row: " +row);
		System.out.println("column: " +column);
		System.out.println("pos: " +(pos));
		
		System.out.println("val: " +value);
		
		
		System.out.println("i: " +i);
		
		System.out.println("weight: " +weight);
		
		
*/
		
		if(weight==0) {
			return 1;

	} 
    	return V;
    
    }
	


	static public class DPQ { 
		private int dist[]; 
		private Set<Integer> settled; 
		private PriorityQueue<Node> pq; 
		private int V; // Number of vertices 
		List<List<Node> > adj; 

		public DPQ(int V) 
		{ 
			this.V = V; 
			dist = new int[V]; 
			settled = new HashSet<Integer>(); 
			pq = new PriorityQueue<Node>(V, new Node()); 
		} 

		// Function for Dijkstra's Algorithm 
		public void dijkstra(List<List<Node> > adj, int src) 
		{ 
			this.adj = adj; 

			for (int i = 0; i < V; i++) 
				dist[i] = Integer.MAX_VALUE; 

			// Add source node to the priority queue 
			pq.add(new Node(src, 0)); 

			// Distance to the source is 0 
			dist[src] = 0; 
			while (settled.size() != V) { 

				// remove the minimum distance node 
				// from the priority queue 
				int u = pq.remove().node; 

				// adding the node whose distance is 
				// finalized 
				settled.add(u); 

				e_Neighbours(u); 
			} 
		} 

		// Function to process all the neighbours 
		// of the passed node 
		private void e_Neighbours(int u) 
		{ 
			int edgeDistance = -1; 
			int newDistance = -1; 

			// All the neighbors of v 
			for (int i = 0; i < adj.get(u).size(); i++) { 
				Node v = adj.get(u).get(i); 

				// If current node hasn't already been processed 
				if (!settled.contains(v.node)) { 
					edgeDistance = v.cost; 
					newDistance = dist[u] + edgeDistance; 

					// If new distance is cheaper in cost 
					if (newDistance < dist[v.node]) 
						dist[v.node] = newDistance; 

					// Add the current node to the queue 
					pq.add(new Node(v.node, dist[v.node])); 
				} 
			} 
		} 


	} 

	// Class to represent a node in the graph 
	static class Node implements Comparator<Node> { 
		public int node; 
		public int cost; 

		public Node() 
		{ 
		} 

		public Node(int node, int cost) 
		{ 
			this.node = node; 
			this.cost = cost; 
		} 

		@Override
		public int compare(Node node1, Node node2) 
		{ 
			if (node1.cost < node2.cost) 
				return -1; 
			if (node1.cost > node2.cost) 
				return 1; 
			return 0; 
		} 
	} 

	public static void main(String[] args) {
		

	//	int[][] map2 ={{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
	//	int[][] map = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
		

		int[][] map = {  {0, 1, 0, 1, 0, 0, 0},{0, 0, 0, 1, 0, 1, 0}};

        int [][] test = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};

		//System.out.println(getWeight(3,map));
		
		
		System.out.println(solution(test));
	}
    
}
