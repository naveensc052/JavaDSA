package DynamicProgramming.KnapSack01;

import java.util.Scanner;

public class MinSumDifSubset {

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
		System.out.print("MinSum Difference is " + minimumDifference(nums));
		scan.close();
	}
	public static int minimumDifference(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int targetSum = 0;
        for(int i:nums){
            targetSum += i;
        }
        boolean[][] dp = new boolean[n + 1][targetSum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    if(dp[i][j] == true)
                        min = Math.min(min, Math.abs(targetSum-2*j));
                }
            }
        }
        return min;
    }
}
