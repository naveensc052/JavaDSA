/*
 * LeetCode 1920 Problem
 */
package Arrays;

public class BuildArrayPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,2,1,5,3,4};
		permute(nums,0);
		System.out.println(nums.toString());		
	}
	static void permute(int[] nums, int start){
        if(start<nums.length){
            int temp = nums[start];
            int result = nums[temp];
            permute(nums,start+1);
            nums[start] = result;
        }
    }
}
