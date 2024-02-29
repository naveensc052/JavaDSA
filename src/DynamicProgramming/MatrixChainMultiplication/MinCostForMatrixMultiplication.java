package DynamicProgramming.MatrixChainMultiplication;

import java.util.Arrays;
import java.util.Scanner;

public class MinCostForMatrixMultiplication {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        // Length n for n-1 matrix orders
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            int num = scan.nextInt();
            nums[i] = num;
        }
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(MinimumCostForMatrixMultiplication(nums,1,n-1,dp));
        scan.close();
    }

    private static int MinimumCostForMatrixMultiplication(int[] nums, int i, int j, int[][] dp) {
        if(i>=j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int val = MinimumCostForMatrixMultiplication(nums, i, k,dp) 
                    + MinimumCostForMatrixMultiplication(nums, k+1, j, dp)  
                    + nums[i-1]*nums[k]*nums[j];
            min = Math.min(min, val);
            System.out.println("Hello");
        }
        return dp[i][j] = min;
    }
}
