package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxNonNegativeSubarray {

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
		solution(nums,size);
	}

	private static void solution(int[] nums, int size) {
		// TODO Auto-generated method stub
		int start = -1;
		int end = -1;
		int maxsum = Integer.MIN_VALUE;
		int cursum = 0;
		int len = 0;
		int maxlen =0;
		for(int i=0;i<size; i++) {
			if(nums[i]>=0) {
				len++;
				cursum += nums[i];
			}
			else {
				cursum = 0;
				len = 0;
			}
			if(cursum > maxsum) {
				maxsum = cursum;
				start = i - len + 1;
				end = i;
				maxlen = len;
			}
			if(cursum == 0 && len>maxlen) {
				maxsum = cursum;
				start = i - len + 1;
				end = i;
				maxlen = len;
			}
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end+1)));
		
	}

}
