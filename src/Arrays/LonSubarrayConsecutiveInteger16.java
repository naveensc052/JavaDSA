package Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class LonSubarrayConsecutiveInteger16 {

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
		// Algorithm Function Calling
		findMaxSubarray(nums,size);
		scan.close();
	}

	private static void findMaxSubarray(int[] nums, int size) {
		// TODO Auto-generated method stub
		int maxLength = 0;
		int start = 0;
		int end = 0;
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<size; j++) {
				int cur = longestConsecutive(Arrays.copyOfRange(nums, i, j+1));
				if(cur > maxLength) {
					maxLength = cur;
					start = i;
					end = j;
				}
			}
		}
		System.out.println("MaxLength is " + maxLength + " and the SubArray is " + Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
	}
	public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num :nums){
            set.add(num);
        }

        for(int num: nums){
            if(!set.contains(num-1)){
                int curNum = num;
                int curLen = 1;
                while(set.contains(curNum + 1)){
                    curLen++;
                    curNum++;
                } 
                if(curLen > max && curLen == nums.length){
                    max = curLen;
                }
            }
        }
        return max;
    }
}
