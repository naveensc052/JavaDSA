package Arrays;

import java.util.Scanner;

public class MaxDifbtTwo22 {

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
		// Brute Force Approach
		bruteforce(nums, size);
		getMaxDiff(nums);
	}

	private static void bruteforce(int[] nums, int size) {
		// TODO Auto-generated method stub
		int dif = 0;
		for(int i=0; i<size; i++) {
			int cur = 0;
			for(int j=i+1; j<size; j++) {
				cur = nums[j] - nums[i];
				if(cur>dif) {
					dif = cur;
				}
			}
		}
		System.out.println("Maximum Difference is " + dif);
	}
    public static void getMaxDiff(int[] A)
    {
        int diff = Integer.MIN_VALUE;
        int n = A.length;
 
        if (n == 0) {
            return;
        }
        int max_so_far = A[n-1]; // similarly opposite way is to use minimum so for
        for (int i = n - 2; i >= 0; i--)
        {
            if (A[i] >= max_so_far) {
                max_so_far = A[i];
            }
            else {
                diff = Integer.max(diff, max_so_far - A[i]);
            }
        }
        System.out.print(diff);
    }
}
