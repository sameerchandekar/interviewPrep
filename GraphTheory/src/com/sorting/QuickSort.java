package com.sorting;

public class QuickSort {

	
	
	public void quickSort(int[] arr,int low,int high) {
		
		if(low < high) {
			
			int pi = partitioning(arr, low, high);
			quickSort(arr, low, pi -1 );
			quickSort(arr, pi + 1 , high);
			
		} 
		
	}

	public int partitioning(int[] arr, int lo, int hi) {
		int i = lo  + 1 ;
		int j = hi;
		
		while(i <= j) {
			
			while(i <= j && arr[++i] < arr[lo])
				if(i == hi) break;
			
			while(j - 1 >= i && arr[--j] > arr[lo]);
				if(j == lo) break;
			
			swap(arr, i , j);
		}
		
		swap(arr, lo, j);
		return j;
		
	}
	
	public int partition(int[] arr, int low, int high) {
	
		int pivot = arr[high];
		
		int i = low -1;
		
		for( int j = low; j <= high; j++) {
			
			if(arr[j] < pivot) {
		
				i++;
				swap(arr, i , j);
				
				// print(arr,i,j);
			}
		}
		swap(arr, i+1, high);
		
		return i + 1;
	}
	
	public void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 10, 5, 15, 1, 2, 20, 7 , 30, 8};
		
		QuickSort q = new QuickSort();
		//q.print(array);
		q.quickSort(array, 0, array.length -1);
		
		q.print(array,-1,-1);
	}
	
	private void print(int[] arr, int idx1, int idx2) {
		for(int i= 0 ; i< arr.length; i++) {
			if(i == idx1 || i == idx2) System.out.print(arr[i] + "* ");
			else System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
