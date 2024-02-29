package DynamicProgramming.MatrixChainMultiplication;

import java.util.Scanner;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        String str = scan.next();
        System.out.println(solveusingRecursion(str, 0, str.length()-1));
        scan.close();
    }

    private static int solveusingRecursion(String str, int i, int j) {
        if(i > j ) {
            return 0;
        } 
        else if(ispalindrome(str.substring(i, j+1 ))){
            return 0;
        }
        else {
            int min = Integer.MAX_VALUE;
            for(int k = i; k < j; k++) {
                int val = solveusingRecursion(str, i, k) + solveusingRecursion(str, k+1, j) + 1;
                min = Math.min(min, val);
            }
            return min;
        }
    }

    private static boolean ispalindrome(String substring) {
        int start = 0; 
        int end = substring.length() - 1;
        while(start <= end) {
            if(substring.charAt(start) != substring.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}

/*
 * 
 * 
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        boolean[][] isPalindrome = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                isPalindrome[start][end] = (s.charAt(start) == s.charAt(end)) && (len <= 2 || isPalindrome[start + 1][end - 1]);
            }
        }

        return solveUsingDP(s, 0, n - 1, dp, isPalindrome);
    }

    private int solveUsingDP(String str, int i, int j, int[][] dp, boolean[][] isPalindrome) {
        if (i >= j || isPalindrome[i][j]) {
            return 0;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            int min = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                if (isPalindrome[i][k]) {
                    min = Math.min(min, solveUsingDP(str, k + 1, j, dp, isPalindrome) + 1);
                }
            }
            return dp[i][j] = min;
        }
    }
}

 */