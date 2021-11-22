package com.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Subarray {
	
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList();
        Arrays.asList(arr);
        int sum = 0 ;
        arr.le
		for(int i=0 ; i < n -1 ; i++) {
			sum = arr[i];
			for(int j = i + 1; j < n  ;j++) {
				sum  =  sum + arr[j];
				if(sum == s) {
					list.add(i);
					list.add(j);
					return list;
				} else if(sum > s) break;
			}
		}
        return list;
	}

}
