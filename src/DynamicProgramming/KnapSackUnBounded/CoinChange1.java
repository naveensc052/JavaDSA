package DynamicProgramming.KnapSackUnBounded;

import java.util.Scanner;

public class CoinChange1 {
    public static void main(String[] args) {
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
        System.out.println(MaxnumberofWays(nums,size,sum));
        scan.close();
    }

    private static int MaxnumberofWays(int[] nums, int size, int sum) {
        int[][] dp = new int[size+1][sum+1];
        for(int i=0; i<nums.length; i++) {
			dp[i][0] = 1;
		}
        for(int i=1; i<=size; i++){
            for(int j=1; j<=sum; j++){
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i][j-nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[size][sum];
    }
}
