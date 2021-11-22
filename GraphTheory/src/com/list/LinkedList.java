package com.list;

public class LinkedList {

	Node head;
	
	public static void main(String[] args) {
		
		LinkedList l =new LinkedList();
		l.add(3);
		l.add(4);
		l.add(5);
	
 		l.reverseBetween(l.head,1,1);
		
		l.print();
		l.reverse();
		l.print();
	}
	
	
	public void add(int i) {
		if(head == null) {
			head =new Node();
			head.value = i;
		}
		else {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next; 
		}
		
		Node n = new Node();
		n.value = i;
		n.prev = temp;
		temp.next = n;
		}
	}
	
	
	public void print() {
		Node tmp = head;
		while(tmp != null) {
			System.out.print(tmp.value + " --> ");
			tmp = tmp.next;
		}
		
	}
	
	
	public void reverse()
	{
	    Node temp = head;
	    while(temp != null) {
	       Node tmp = temp.next;
	       temp.next = temp.prev;
	       temp.prev = tmp;
	       if(tmp == null) head = temp;
	       temp = tmp;
	    }
	    
	    
	    
	   
	   
	    
	}
	
	 public Node reverseBetween(Node head, int left, int right) {
	        //System.out.print("start");
	           Node prev = head;
	           //prev.next = null;
	           Node curr = head.next;
	           
	           while(curr != null) {
	               Node next = curr.next;
	               curr.next = prev;
	               prev = curr;
	               curr = next;
	               
	           }
	           
	           head.next = null;
	           //prev.next = curr.next;
	           return prev;
	       }
	
}
