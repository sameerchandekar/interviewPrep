package com.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



public class KruskalsMST {

	private Queue<Edge> mst  = new LinkedList<Edge>();
	
	public KruskalsMST(EdgeWeightedGraph g) {
		Queue<Edge> pQueue = new PriorityQueue<Edge>();
		for(Edge e : g.edges()) {
			pQueue.add(e);
		}
		
		UnionFind uf = new UnionFind(g.V);
		
		while(!pQueue.isEmpty() && mst.size() < g.V - 1) {
			Edge e = pQueue.remove();
			int v = e.eigther() , w = e.other(v);
			if(! uf.quickConnected(v,w)) {
				uf.quickUnion(v,w );
				mst.add(e);
			}
		}
	} 
	
	public Iterable<Edge> edges() {
		return mst;
	}
}
