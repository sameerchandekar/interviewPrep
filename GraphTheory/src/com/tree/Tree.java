package com.tree;

import java.util.Stack;

import com.queue.Queue;

public class Tree {

	private TreeNode root;

	void add(int value) {

		TreeNode node = new TreeNode(value);
		if (root == null) {
			root = node;
			return;
		}
		System.out.println("Added " + addNode(this.root, node).getValue());
	}

	TreeNode addNode(TreeNode root, TreeNode node) { 

		if (root == null) {
			root = node;
			return root;
		}

		if (root.compareTo(node) == -1) {
			root.setRight(addNode(root.getRight(), node));
		} else {
			root.setLeft(addNode(root.getLeft(), node));
		}

		return root;
	}

	void add(TreeNode node) {

		if (this.root == null) {
			this.root = node;
			return;
		}

		boolean isLeft = false;
		TreeNode current = this.root;
		TreeNode parent = null;

		while (current != null) {

			if (root.compareTo(node) == 1) {
				parent = current;
				current = current.getRight();
				isLeft = false;
			} else {
				parent = current;
				current = current.getLeft();
				isLeft = true;
			}
		}

		if (isLeft)
			parent.setLeft(node);
		else
			parent.setRight(node);
	}

	void traverse() {
		/*
		 * System.out.println("PreOrder"); inorder(root);
		 */ 
		  System.out.println("InOrder"); preOrder(root);
		 
		//System.out.println("postorder");
		// postOrder(root);
	}

	void inorder(TreeNode root) {

		if (root == null)
			return;
		System.out.println(root.getValue());
		inorder(root.getLeft());
		inorder(root.getRight());

	}

	void preOrder(TreeNode root) {

		if (root == null)
			return;

		preOrder(root.getLeft());
		System.out.println(root.getValue());
		preOrder(root.getRight());

	}

	void postOrder(TreeNode root) {

		if (root == null)
			return;

		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(root.getValue());

	}

	public static void main(String[] args) {

		System.out.println(" -- Class Tree -- ");
		Tree t = new Tree();

		t.add(4);
		t.add(1);
		t.add(2);
		t.add(3);
		t.add(6);
		t.add(5);
		t.add(7);
		t.add(0);

		 t.traverse();

		// System.out.println("Iterative pre-order");
		// t.iPreOrder(t.root);

		System.out.println("Iterative post-order");
	//	t.iPostOrder(t.root);

		System.out.println(" Iterative In Order ");
		t.iInOrder(t.root);
		
		
		System.out.println("BFS");
		// t.bfs(t.root);
		// t.printTree(t.root);
	}

	void iPreOrder(TreeNode node) {
		if (node == null)
			return;

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(node);
		while (!s.isEmpty()) {
			TreeNode n = s.pop();
			System.out.println(n.getValue());

			if (n.getRight() != null) {
				s.push(n.getRight());
			}
			if (n.getLeft() != null) {
				s.push(n.getLeft());
			}
		}
	}

	void iPostOrder(TreeNode node) {

		if (node == null)
			return;

		Stack<TreeNode> s = new Stack<TreeNode>();

		TreeNode lastVisited = null;

		while (!s.isEmpty() || node != null) {

			if (node != null) {
				s.push(node);
				node = node.getLeft();
			} else {

				TreeNode peek = s.peek();

				if (peek.getRight() != null && lastVisited != peek.getRight()) {
					node = peek.getRight();
				} else {
					System.out.println(peek.getValue());
					lastVisited = s.pop();
				}
			}
		}

	}

	void iInOrder(TreeNode node) {

		if (node == null) return;

		Stack<TreeNode> s = new Stack<TreeNode>();

		while (!s.isEmpty() || node != null) {

			if (node != null) {
				s.push(node);
				node = node.getLeft();
			} else {

				TreeNode pop = s.pop();
				System.out.println(pop.getValue());

				if (pop.getRight() != null) {
					node = pop.getRight();
				}
			}
		}

	}

	void bfs(TreeNode node) {

		
		Queue<TreeNode> q = new Queue<TreeNode>();
		q.add(node);

		while (!q.isEmpty()) {
			TreeNode n = q.remove();
			System.out.println(n.getValue());

			if (n.getLeft() != null)
				q.add(n.getLeft());
			if (n.getRight() != null)
				q.add(n.getRight());

		}
	}
	
	

	
}
