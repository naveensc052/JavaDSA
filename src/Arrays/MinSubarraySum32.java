package Arrays;

import java.util.Scanner;

public class MinSubarraySum32 {

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
		System.out.print("Enter the Target:- ");
		int target = scan.nextInt();
		System.out.println("Min Length Subarray satisfying given condition is " + minSubArrayLen(target,nums));
	}
	public static int minSubArrayLen(int target, int[] nums) {
        int cur = 0;
        int minlen = Integer.MAX_VALUE;
        int len = 0;
        int low = 0;
        int high = 0;
        for(low=0; low<nums.length; low++){
            while(high<nums.length && cur<target){
                cur += nums[high];
                high++;
                len++;
            }
            if(minlen>len && cur>=target){
                minlen = len;
            }
            cur -= nums[low];
            len--;
        }
        if(minlen == Integer.MAX_VALUE){
            return 0;
        }
        return minlen;
    }
}
