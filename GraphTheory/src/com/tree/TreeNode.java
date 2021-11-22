package com.tree;

public class TreeNode implements Comparable {

	TreeNode left;
	int value;
	TreeNode right;
	
	TreeNode(int value) {
		this.value = value;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	@Override
	public int compareTo(Object arg0) {
		TreeNode n = (TreeNode) arg0;
		if (this.getValue() > n.getValue()) return 1;
		if (this.getValue() < n.getValue()) return -1;
		return 0;
	}

	
}
