package com.sorting;

public class MergeSort {

	
	public static void merge(int[] arr, int[] aux,int lo, int mid,  int hi) {
		
		for(int k = lo ; k <= hi; k++ ) {
			aux[k] = arr[k];
		}
		
		int i = lo, j = mid + 1;
		
		for(int k = lo ; k <= hi; k++) {
			
			if(i > mid) arr[k] = aux[j++];
			else if (j > hi) arr[k] = aux[i++];
			else if (aux[j] < aux[i]) arr[k] = aux[j++];
			else arr[k] = aux[i++];
		}
	}
	
	
	public static void sort(int[] arr, int[] aux, int lo, int hi) {
		
		if(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			sort(arr, aux, lo, mid);
			sort(arr, aux, mid +1 , hi);
			merge(arr,aux, lo, mid,hi);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,6,3,8,2,9,4,8,4,2};
		int [] aux = new int[arr.length];
		
		sort(arr,aux,0, arr.length -1);
		
		
		for(int i : arr) {
			System.out.print(i);
		}
		
	}
}
