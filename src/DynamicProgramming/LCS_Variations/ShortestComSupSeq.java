package DynamicProgramming.LCS_Variations;

import java.util.Scanner;

public class ShortestComSupSeq {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        String y = scan.next();
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

        // Build the Longest Common Supersequence
        StringBuilder supersequenceBuilder = new StringBuilder();
        int i = x.length(), j = y.length();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                supersequenceBuilder.insert(0, x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    supersequenceBuilder.insert(0, x.charAt(i - 1));
                    i--;
                } else {
                    supersequenceBuilder.insert(0, y.charAt(j - 1));
                    j--;
                }
             }
         }
 
        // Add the remaining characters from x and y
        while (i > 0) {
             supersequenceBuilder.insert(0, x.charAt(i - 1));
             i--;
        }
        while (j > 0) {
            supersequenceBuilder.insert(0, y.charAt(j - 1));
            j--;
        }
        System.out.println(supersequenceBuilder.toString());
        return x.length()+y.length()-dp[x.length()][y.length()];
    }
}
