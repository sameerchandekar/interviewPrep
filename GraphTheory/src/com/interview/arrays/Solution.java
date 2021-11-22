package com.interview.arrays;

import java.util.Arrays;
import java.util.Queue;

import com.list.LinkedList;

class Solution {
    int countTriplet(int arr[], int n) {
         int count = 0;
        
	    for(int i=0; i< n; i++) {
	        for(int j = i + 1; j < n  ; j++) {
	           if(contains(arr, arr[i] + arr[j])) count++; 
	        }
	    }
	    
	    return count;
    }
    
    boolean contains(int arr[], int val) {
    	System.out.println(val);
        for(int i=0; i< arr.length; i++) {
            if(arr[i] == val) return true;
        }
        return false;
    }
    
    public static void main(String args[]) {
    	/*Solution s = new Solution();
    	int[] arr = {1,5,3,2}; 
    	
    
    	
    	
    	s.countTriplet(arr, arr.length);
    	*/
    
    	Queue<TreeNode> q =  new LinkedList();
    
    	q.re
    	String S = "i.like.this.program.very.much";
    	 String[] arr = S.split("[.]+");
         int i = 0; 
     	int j = arr.length -1;
     	
     	while(i < j) {
     		String temp = arr[i];
     		arr[i] = arr[j];
     		arr[j] = temp;
     		i++; j--;
     	}
     	
     	System.out.println(String.join(".",Arrays.asList(arr)));
    	
    }
}