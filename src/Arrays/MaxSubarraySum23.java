package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSubarraySum23 {

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
		// Algorithm
		maxSubArray(nums);
		scan.close();
	}
	public static void maxSubArray(int[] nums) {
        int startindex = -1;
        int endindex = -1;
        int maxending = 0;
        int maxsofar = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
        	maxending += nums[i];
        	if(maxending <= nums[i]) {
        		maxending = nums[i];
        		startindex = i;
        	}
        	if(maxsofar < maxending) {
        		endindex = i;
        		maxsofar = maxending;
        	}
        }
        System.out.println("Max SumSubarray " + maxsofar + " and the is " + Arrays.toString(Arrays.copyOfRange(nums, startindex, endindex + 1)));
    }
}
