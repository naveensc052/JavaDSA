package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Mergearrayinvacant11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size1: ");
		int size1 = scan.nextInt();
		int[] nums1 = new int[size1];
		System.out.println("Enter elements1: ");
		for(int i=0; i<size1; i++) {
			int e = scan.nextInt();
			nums1[i] = e;
		}
		System.out.print("Enter the Size2: ");
		int size2 = scan.nextInt();
		int[] nums2 = new int[size2];
		System.out.println("Enter elements2: ");
		for(int i=0; i<size2; i++) {
			int e = scan.nextInt();
			nums2[i] = e;
		}
		// Algorithm
		System.out.println("Before : " +"nums1 = " + Arrays.toString(nums1) + "\n" + "nums2 = " + Arrays.toString(nums2));
		MergeMethod(nums1,nums2,size1,size2);
		System.out.println("After : " +"nums1 = " + Arrays.toString(nums1) + "\n" + "nums2 = " + Arrays.toString(nums2));
		scan.close();
	}

	private static void MergeMethod(int[] nums1, int[] nums2, int size1, int size2) {
		// TODO Auto-generated method stub
		int nonzeroindex = 0;
		for(int i=0; i<size1; i++) {
			if(nums1[i]>0) {
				int temp = nums1[i];
				nums1[i] = nums1[nonzeroindex];
				nums1[nonzeroindex] = temp;
				nonzeroindex++;
			}
		}
		nonzeroindex--;
		for(int i= size1-1; i>=0; i--) {
			if(nonzeroindex>=0 && nums1[nonzeroindex]>nums2[size2-1]) {
				nums1[size1-1] = nums1[nonzeroindex];
				size1--;
				nonzeroindex--;
			}
			else {
				nums1[size1-1] = nums2[size2-1];
				size2--;
				size1--;
			}
		}
	}

}
