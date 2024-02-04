package DynamicProgramming;

import java.util.Scanner;

public class HitTheLottery {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = {1, 5, 10, 20, 100};
        int ans = solution(nums, n);
        System.out.println(ans);
        scan.close();
    }

    private static int solution(int[] nums, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int coin : nums) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[n];
    }
}
