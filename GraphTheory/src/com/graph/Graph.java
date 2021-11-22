package com.graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph<T> {

	Graph(Map<Node<T>,List<Node<T>>> list) {
		this.adj = list;
	}
	
	Graph() {
	}
	
	private Map<Node<T>, List<Node<T>>> adj = new HashMap();
	
	public static void main(String[] args) {

		Graph<Integer> g = new Graph<Integer>();

		g.addEdge( 0, 1, 2);
		g.addEdge( 0, 4, 3);
		g.addEdge( 1, 2, 8);
		g.addEdge( 1, 3, 3);
		g.addEdge( 1, 4, 2);
		g.addEdge( 2, 3, 1);
		g.addEdge( 3, 4, 5);
		g.addEdge( 4, 0, 5);
		g.addEdge( 1, 0, 5);
		//g.printGraph();
		
		BFS<Integer> bfs = new BFS<Integer>();
		//bfs.traverse(g);
		
		DFS<Integer> dfs = new DFS<Integer>();
		dfs.traverse(g);
		dfs.traveseRecurse(g);
		
		Dijkstras d = new Dijkstras();
		d.traverse(g, g.getNode(0), g.getNode(4));
		
		
	}

	void addEdge(T svert, T dvert, int weight) {
		Node sNode = new Node(svert,0);
		Node dNode = new Node(dvert,weight);
		
		List<Node<T>> nodes = adj.get(sNode);
		if(nodes == null) {
			List<Node<T>> l = new LinkedList<>();
			l.add(dNode);
			adj.put(sNode, l);
		}
		else {
			nodes.add(dNode);
		}
	}

	void printGraph() {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i);
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print("-> " + adj.get(i).get(j).getData());
			}
			System.out.println();
		}
	}
	
	Node<T> getRandomVertex() {
		for(Node<T> n: adj.keySet()) {
			return n;
		}
		return null;
	}
	
	List<Node<T>> getEdges(Node<T> vertex) {
		List<Node<T>> l = adj.get(vertex);
		return l == null ? new LinkedList() : l;
	}
	
	
	public Set<Node<T>> getAllNodes() {
		Set<Node<T>> s = new HashSet<Node<T>>();
		for(Entry<Node<T>, List<Node<T>>> n : this.adj.entrySet()) {
			s.addAll(n.getValue());
		}
		return s;
	}
	
	public Node<T> getNode(int val) {
		for(Node<T> n : adj.keySet()) {
			if(n.getWeight() == val) return n;
		}
		return null;
	}
}
