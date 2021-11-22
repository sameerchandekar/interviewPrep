package com.graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DFS<T> {
	
	
	 public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
	    {
		 	Stack<Integer> stack = new Stack();
		 	stack.add(V);
		 	
	        ArrayList<Integer> visited  = new ArrayList<>();
	        
	        List<Integer> l = adj.get(V);
	        while(visited.size() < adj.size()) {
	        	if(!visited.contains(stack.peek())) {
	        		int val = stack.pop();
	        		visited.add(val);
	        		for(Integer i : adj.get(val)) stack.push(i);
	        	}	
	        }
	        
	        return visited;
	       
	}
	
	public void traverse(Graph<T> g) {
		
		
		
		System.out.println("-- Start DFS --");
		int w = 0; 
		Stack<Node<T>> s = new Stack<Node<T>>();
		Map<Node<T>,Boolean> m = new HashMap();
		s.push(g.getRandomVertex());
		System.out.print("visiting  ");
		while(!s.isEmpty()) {
			Node<T> v = s.pop();
			if(!isVisited(v,m)) {
				System.out.print(v.getData() + " --> ");
				m.put(v, true);	
				w = w + v.getWeight();
			}
			
			addNeighbours(g, v, s, m);
		}
		System.out.println("Total Weight "  + w);
	}
	
	
	public void traveseRecurse(Graph<T> g) {
		System.out.println("-- Start DFS using recursion --");
		Map<Node<T>,Boolean> m = new HashMap();
		recurse(g.getRandomVertex(),m,g);
	}
	
	public void recurse(Node<T> node , Map<Node<T>,Boolean> m , Graph<T> g) {
		
		System.out.println(node.getData());
		m.put(node, true);
		for(Node<T> n : g.getEdges(node)) {
			if(!isVisited(n, m)) recurse(n , m,g);
		}
	}
	
	

	private void addNeighbours(Graph<T> g, Node<T> v, Stack<Node<T>> s, Map<Node<T>,Boolean> m) {
		for(Node<T> vert : g.getEdges(v)) {
			// boolean visited = m.get(vert) == null ? false : m.get(vert);
			if(!isVisited(vert, m)) {
				s.add(vert);	
			}
		}
	}
	
	private boolean isVisited(Node<T> vert,  Map<Node<T>,Boolean> m) {
		return m.get(vert) == null ? false : m.get(vert);
	}
}
