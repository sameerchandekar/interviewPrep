package com.graph;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS<T> {

	public void traverse(Graph<T> g) {
		System.out.println("-- Start BFS --");
		int w = 0;
		Map<Node<T>,Boolean> m = new HashMap<Node<T>,Boolean>();
		Queue<Node<T>> q = new PriorityQueue<Node<T>>();
		q.add(g.getRandomVertex());
		System.out.print("Visiting  ");
		while(!q.isEmpty()) {
			Node<T> v = q.remove();
			if(!isVisited(v,m)) {
				w = w + v.getWeight();
				System.out.print(v.getData() + " --> ");
			}
			m.put(v, true);	
			addNeighbours(g, v, q, m);
		}	
		System.out.println("Total cost " + w);
	}
	
	private void addNeighbours(Graph<T> g, Node<T> v, Queue<Node<T>> q, Map<Node<T>,Boolean> m) {
		for(Node<T> vert : g.getEdges(v)) {
			boolean visited = m.get(vert) == null ? false : m.get(vert);
			if(!visited) {
				q.add(vert);
			}
		}
	}
	
	private boolean isVisited(Node<T> vert,  Map<Node<T>,Boolean> m) {
		return m.get(vert) == null ? false : m.get(vert);
	}
}
