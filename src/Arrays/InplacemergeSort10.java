package Arrays;

import java.util.*;

public class InplacemergeSort10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size: ");
		int size1 = scan.nextInt();
		int[] nums1 = new int[size1];
		System.out.println("Enter elements1: ");
		for(int i=0; i<size1; i++) {
			int e = scan.nextInt();
			nums1[i] = e;
		}
		System.out.print("Enter the Size: ");
		int size2 = scan.nextInt();
		int[] nums2 = new int[size2];
		System.out.println("Enter elements2: ");
		for(int i=0; i<size2; i++) {
			int e = scan.nextInt();
			nums2[i] = e;
		}
		// Algorithm
		System.out.println("Before : " +"nums1 = " + Arrays.toString(nums1) + "\n" + "nums2 = " + Arrays.toString(nums2));
		inplacesortusingmerge(nums1,size1, nums2, size2);
		System.out.println("After : " +"nums1 = " + Arrays.toString(nums1) + "\n" + "nums2 = " + Arrays.toString(nums2));
		scan.close();
	}

	private static void inplacesortusingmerge(int[] nums1, int size1, int[] nums2, int size2) {
		// TODO Auto-generated method stub
		for(int i=0; i<size1; i++) {
			if(nums1[i]>nums2[0]) {
				int temp = nums1[i];
				nums1[i] = nums2[0];
				nums2[0] = temp;
			}
			int first = nums2[0];
			int j;
			for(j=1; j<size2 && nums2[j] < first ; j++) {
				nums2[j-1] = nums2[j];
			}
			nums2[j-1] = first;
		}
	}


}
