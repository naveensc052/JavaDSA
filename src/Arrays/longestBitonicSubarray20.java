package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class longestBitonicSubarray20 {

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
		// With ExtraSpace
		withExtraSpace(nums, size);
		withoutExtraSpace(nums,size);
		scan.close();
	}

	private static void withoutExtraSpace(int[] nums, int size) {
		// TODO Auto-generated method stub
		int i=0;
		int len = 0;
		int endindex = -1;
		while(i+1<size) {
			int cur = 1;
			while(i+1<size && nums[i] < nums[i+1]) {
				i++;
				cur++;
			}
			while(i+1<size && nums[i] > nums[i+1]) {
				i++;
				cur++;
			}
			if(cur>len) {
				len = cur;
				endindex = i;
			}
		}
		System.out.println("The length of the longest bitonic subarray is " + len);
		System.out.println("SubArray is " + Arrays.toString(Arrays.copyOfRange(nums, endindex - len + 1, endindex +1 )));
	}

	private static void withExtraSpace(int[] nums, int size) {
		// TODO Auto-generated method stub
		int len = 0;
		int[] l = new int[size];
		l[0] = 1;
		for(int i=1; i<size; i++) {
			l[i] = 1;
			if(nums[i]>nums[i-1]) {
				l[i] = l[i-1] + 1;
			}
		}
		int[] r = new int[size];
		r[size-1] = 0;
		for(int i=size-2; i>=0; i--) {
			r[i] = 1;
			if(nums[i]>nums[i+1]) {
				r[i] = r[i+1] + 1;
			}
		}
		int start = -1;
		int end = -1;
		for(int i=0; i<size; i++) {
			int current = l[i] + r[i] - 1;
			if(current>len) {
				len = current;
				start = i - l[i] + 1;
				end = i + r[i] -1;
			}
		}
		System.out.println("The length of the longest bitonic subarray is " + len);
		System.out.println("SubArray is " + Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
	}

}
