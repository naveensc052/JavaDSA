package DynamicProgramming.KnapSack01;

import java.util.Scanner;

public class SubsetSum {

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
		System.out.println(KnapSackVariantSubsetSum(nums, size,sum, 0));
		scan.close();
	}

	private static boolean KnapSackVariantSubsetSum(int[] nums, int size, int targetSum, int index) {
		// TODO Auto-generated method stub
		
		int n = nums.length;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        // Base case: an empty subset can always achieve a sum of 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table using bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                // If the current element is greater than the target sum, exclude it
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, consider either including or excluding the current element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // The final result is stored in the bottom-right cell of the dp table
        return dp[n][targetSum];
	}

}
