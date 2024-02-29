package Arrays;

import java.util.Scanner;

public class RainWaterTrap37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size: ");
		int size = scan.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter elements: ");
		for(int i=0; i<size; i++) {
			int e = scan.nextInt();
			nums[i] = e;
		}
		System.out.println("Maximum water that can be trapped is " + trapwater(nums,size));
		scan.close();
	}

	private static int trapwater(int[] nums, int size) {
		// TODO Auto-generated method stub
		int water = 0;
		int left = 0; 
		int right = nums.length - 1;
		int maxleft = nums[left];
		int maxright = nums[right];
		while(left<right) {
			if(nums[left] <= nums[right]) {
				left++;
				maxleft = Math.max(nums[left],maxleft);
				water += maxleft - nums[left];
			}else {
				right--;
				maxright = Math.max(nums[right], maxright);
				water += maxright - nums[right];
			}
		}
		
		return water;
	}
	
	public static int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int[] left = new int[height.length-1];
        int n = height.length;
        int water = 0;
        left[0] = Integer.MIN_VALUE;
        for(int i=1; i<n-1; i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        int right = Integer.MIN_VALUE;
        for(int i = n-2; i>=1; i--){
            right = Math.max(right,height[i+1]);
            int minHeight = Math.min(left[i], right);
            if (minHeight > height[i]) {
                water += minHeight - height[i];
            }
        }
        return water;
    }

}
