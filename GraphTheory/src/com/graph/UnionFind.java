package com.graph;

public class UnionFind {
	
	private int[] id ;
	private int[] sz;   // to store number for node in each connected component tree
	
	public UnionFind(int N) {
		id = new int[N];
		sz = new int[N];
		for(int i = 0; i < N ; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i) {
		while(i != id[i]) {
			i = id[i];
			id[i] = id[id[i]];    // This line is for path compression.  we make node point to its grandparent directly 
   		}
		return i;
	}
	
	@Deprecated
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public boolean quickConnected(int p, int q) {
		return root(p) == root(q);
	}
	
	@Deprecated
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for(int i =0; i < id.length; i++) {
			if(id[i] == pid) id[i] = qid;
		}
	}
	
	public void quickUnion( int p , int q) {
		int i = root(p);
		int j = root(q);
		if(i == j ) return;
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}
		else {
			id[j] = i;
			sz[i] += sz[j]; 
		}
	}
}
