package com.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkstras {
	
	List<Node<Integer>> visitedInorder = new LinkedList<>();
	
	boolean[] visited = new boolean[5]; 
	
	int[] distance = new int[5];
	
	Set<Integer> settled = new HashSet();
	
	public void traverse(Graph<Integer> g , Node<Integer> start, Node<Integer> finish) {
	
		System.out.println("-- Dijkstra traversal --");
		int f = 3; 
		
		Queue<Node<Integer>> unvisited = new PriorityQueue<Node<Integer>>();
		
		for(int i=0; i<5; i++) {
			distance[i] = Integer.MAX_VALUE; 
		}
		
		distance[0] = 0;  
		unvisited.add(new Node<Integer>(0,0));
		
		while(settled.size() != 5) {
			
			Node<Integer> n = unvisited.remove();
			settled.add((Integer) n.getData());
			if(f == n.getData()) break;
			addNeighbours(n, g, unvisited);
			
		}
		
		print();
		
	}
	
	private void addNeighbours(Node<Integer> n, Graph<Integer> g, Queue<Node<Integer>> unvisited) {
		
		int edgeDistance = -1; 
		int newDistance = -1;
		
		for(Node<Integer> neighbour : g.getEdges(n)) {
			
			if(!settled.contains(neighbour.getData())) {
			
				edgeDistance = neighbour.getWeight();
				System.out.println("Edge distance from " + n.getData() + " --> " + neighbour.getData() + " is " + edgeDistance);
				newDistance = distance[n.getData()] + edgeDistance;
				
				System.out.println("New Distance" + newDistance);
				
				if(newDistance < distance[neighbour.getData()]) {
					distance[neighbour.getData()] = newDistance;
				}
			
				neighbour.setWeight(distance[neighbour.getData()]);
				unvisited.add(new Node<Integer>(neighbour.getData(),distance[neighbour.getData()]));
			}
			
		}
	}
	

	void print() {
		/*int weight = 0 ;
		System.out.print("Start ");
		for(Node n : visitedInorder) {
			weight = weight + n.getWeight();
			System.out.print(n.getData() + " --> ");
		}
		System.out.print(" Finish");
		System.out.println("Total weight " + weight );*/
		
		for(int i=0; i<5; i++) {
			System.out.println("Source to " + i + " distance is " + distance[i]);
		}
	}
	
	
}
