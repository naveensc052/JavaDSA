package DynamicProgramming.LCS_Variations;

import java.util.Scanner;

public class LonPalindromeSubSeq {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        String y = "";
        for(int i=0; i<x.length(); i++){
            y += x.charAt(x.length()-1-i);
        }
        int valuethroughTopDownApproach = TopDownApproach(x,y);
        System.out.println("Top Down Approach:- " + valuethroughTopDownApproach);
        scan.close();
    }
    private static int TopDownApproach(String x, String y) {
        int[][] dp = new int[x.length()+1][y.length()+1];
        for(int i=1; i<=x.length(); i++){
            for(int j=1; j<=y.length(); j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
         // Reconstruct the LCS string
        StringBuilder lcs = new StringBuilder();
        int i = x.length(), j = y.length();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs.insert(0, x.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Print or use the LCS string
        System.out.println("LCS: " + lcs.toString());
        return dp[x.length()][y.length()];
    }
}
