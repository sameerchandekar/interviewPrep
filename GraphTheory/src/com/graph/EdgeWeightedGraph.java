package com.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EdgeWeightedGraph {

	public final int V;
	private final Set<Edge>[] adj;
	
	public EdgeWeightedGraph(int V) {
		this.V = V;
		adj = new HashSet[V];
		for(int v= 0 ; v < V; v++) {
			adj[v] = new HashSet<Edge>();
		}
	}
	
	public void addEdge(Edge e) {
		int v = e.eigther() , w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}
	
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}
	
	public Iterable<Edge> edges() {
		return Arrays.stream(adj).flatMap(s -> s.stream()).collect(Collectors.toSet());
	}
}
