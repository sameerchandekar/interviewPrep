package com.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PracticeDijktra {
	
	
	static class Node {
		int val; 
		int dist;
		
		Node(int v, int dist) {
			this.val = v;
			this.dist = dist;
		}
	}
	
	
	public static void dijkstra(List<List<Node>> adj) {
	
		int v = adj.size();
		boolean[] visited = new boolean[v];
		PriorityQueue<Node> queue = new PriorityQueue<Node>((a , b) -> a.dist - b.dist);
		queue.add(new Node( 0 , 0));
		int distance[] = new int[v];
		distance[0] = 0;
		for(int i = 1 ; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0 ; i < v  - 1; i ++) {
			
			int vertex = queue.remove().val;
			visited[vertex] = true;
			
			for(Node neighbour : adj.get(vertex)) {
				
				if(!visited[neighbour.val]) {
		
					int newDistance = distance[vertex]  + neighbour.dist;
					if(newDistance < distance[neighbour.val]) {
						distance[neighbour.val]  = newDistance;
						queue.add(new Node(neighbour.val, newDistance));
					}
					
				}
				
			}
		}
		
		for(int i = 0 ; i < distance.length; i++) {
			System.out.println("Distance to " + i  + " is " + distance[i]);
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		List<List<Node>> adj = new ArrayList();
		
		dijkstra(adj);
	}
	
}
