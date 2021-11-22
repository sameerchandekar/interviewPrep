package com.graph;

public class Node<T> implements Comparable<Node<T>> {
	
	T data;
	int weight;
	boolean visited;
	
	Node(T data, int weight) {
		this.data = data;
		this.weight = weight;
	}
	
	Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
	// 	result = prime * result + (visited ? 1231 : 1237);
	//	result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*if (getClass() != obj.getClass())
			return false;
		
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (visited != other.visited)
			return false;
		if (weight != other.weight)
			return false;*/
		Node other = (Node) obj;
		if(this.data != other.data) return false;
		return true;
	}

	@Override
	public int compareTo(Node<T> node) {
		// TODO Auto-generated method stub
		if(this.weight > node.weight) return 1 ;
		if(this.weight < node.weight) return -1 ;
		return 0;
	}
	
	
	
	
}
