package com.queue;

import java.util.List;
import java.util.ArrayList;

public class Queue<T> {

	private List<T> queue = new ArrayList<T>();
	
	public void add(T element) {
		queue.add(element);
	}
	
	public T remove() {
		if(queue.isEmpty()) return null;
		else {
			return queue.remove(0);
		}
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
