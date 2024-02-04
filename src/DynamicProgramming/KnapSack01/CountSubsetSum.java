package DynamicProgramming.KnapSack01;

import java.util.Scanner;

public class CountSubsetSum {

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
		System.out.print("Enter Sum:- ");
		int sum = scan.nextInt();
		System.out.print("Count is " + count(nums,sum));
		scan.close();
	}

	private static int count(int[] nums, int sum) {
		// TODO Auto-generated method stub
		int[][] dp = new int[nums.length+1][sum+1];
		for(int i=0; i<nums.length; i++) {
			dp[i][0] = 1;
		}
		for(int i=1; i<=nums.length; i++) {
			for(int j=1; j<= sum; j++) {
				if(j>= nums[i-1]) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[nums.length][sum];
	}

}
