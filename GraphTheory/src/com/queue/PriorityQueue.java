package com.queue;

public class PriorityQueue {

	int[] pq ;
	int n = 0;
	
	public PriorityQueue(int size) {
		pq = new int[size];
	}
	
	public boolean isFull() {
		return n == pq.length - 1 ? true : false; 
	}
	
	public void insert(int val) {
		if(!isFull()) {
			pq[n++] = val;
			swim(n);
		}
		
	}
	
	private void swim(int k) {
		while(k > 1 && pq[k/2] < pq[k]) {
			swap(k/2, k);
			k = k/2;
		}
	}

	private void swap(int i , int j ) {
		int t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	private void sink(int k ) {
		while(2* k <= n) {
			int j = 2 * k;
			if(j < n && pq[j] < pq[j+1]) j++;
			if(! (pq[k] < pq[j])) break;
			swap(k,j);
			k = j;
		}
	}
	
	public int deleteMax() {
		int max = pq[1];
		swap(1, n--);
		sink(1);
		pq[n+1] = -1;
		return max;
	}
	
}
