package DivideandConquer;

import java.util.Scanner;

public class binarysearch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size:- ");
		int size = scan.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter the elements:- ");
		for(int i=0; i<size; i++) {
			int value = scan.nextInt();
			nums[i] = value;
		}
		System.out.print("Enter the target:- ");
		int target = scan.nextInt();
		System.out.println("index is " + Solution(nums,0,size-1, target));
		scan.close();
	}

	private static int Solution(int[] nums, int i, int j, int target) {
		// TODO Auto-generated method stub
		while(i<=j) {
			int mid = i + (j-i)/2;
			if(nums[mid] == target) {
				return mid + 1;
			}
			else if(nums[mid] > target) {
				j = mid - 1;
			}
			else {
				i = mid + 1;
			}
			
		}
		return -1;
	}

}
