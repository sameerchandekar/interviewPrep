package com.multithreading.oddeven;

public class Print {

	static int counter;
	static Object obj = new Object();
	
	static final int limit = 10;
	
	static void printEven() {
		synchronized(obj) {
			while(counter < limit) {
				if(counter % 2 == 0 ) {
					System.out.println(Thread.currentThread().getName() + " " + counter);
					counter++;
					obj.notify();
					
				}
				else {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			}
	}
	
	synchronized static void printOdd() {
		synchronized(obj) {
			while(counter < limit) {
				if(counter % 2 != 0 ) {
					System.out.println(Thread.currentThread().getName() + " " + counter);
					counter++;
					obj.notify();
					
				}
				else {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			}
	}
	
	public static void main(String[] args) {
	

		Thread t1 = new Thread(() -> printEven());
		t1.setName("even");
		Thread t2 = new Thread(() -> printOdd());
		t2.setName("odd");
		t1.start();
		t2.start();
		
				
	}

}
