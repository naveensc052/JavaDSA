package Sorting;
import java.util.*;

public class MergeSort {
	
	public static void sort(int[] elements, int low, int mid, int high) {
		int[] b = new int[high-low + 1];
		int i= low; 
	}
	
	public static void merge(int[] elements, int low, int high) {
		if(low<high) {
			int mid = low + (high-low)/2;
			merge(elements,low,mid);
			merge(elements,mid+1,high);
			sort(elements, low, mid, high);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] elements = new int[n];
		System.out.print("Enter Elements: ");
		for(int i=0; i<n; i++) {
			int ele = scan.nextInt();
			elements[i] = ele;
		}
		merge(elements,0,n-1);
		
	}

}
