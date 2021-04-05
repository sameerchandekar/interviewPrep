/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        int n= sc.nextInt();
        List<String> ips = new ArrayList<String>();
        
		for(int i = 0; i< n ; i++) {
		    char[] chars = sc.next().toCharArray();
		    System.out.println(removeDup(chars, 0));
		}
		
		
	}
	
	static String removeDup(char[] val, int k) {
	    
	    boolean recurse = false;
	    
	    if(val.length == 0 || val.length == 1) {
	        return new String(val);
	    }
	    
	    for(int i = 0 ; i < val.length - 1 ; i++) {
	        
	    if(val[i] == val[i + 1]) {
	        recurse = true;
	        int j = i + 1; 
	        while( (j + 1) < val.length && val[j] == val[j+1]) {
	            j++;
	        }
	        String s = new String(val);
	        String newVal = s.substring(0,i) + s.substring(j+1,s.length());
	        val = newVal.toCharArray();
	    }
	    
	    }
	    
	    if(recurse) {
	        return removeDup(val ,0);
	    } 
	      
	    return new String(val);    
	    
	    
	}
}