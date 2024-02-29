package DynamicProgramming.LCS_Variations;

import java.util.Scanner;

public class LongComSubseq {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        String y = scan.next();
        int valuethroughRecursion = RecursiveApproachLCS(x,y);
        System.out.println("Recursive Approach:- " + valuethroughRecursion);
        int[][] dp = new int[x.length()+1][y.length()+1];
        for(int i=0; i<=x.length(); i++){
            for(int j=0; j<=y.length(); j++){
                dp[i][j] = -1;
            }
        }
        int valuethroughBottomUpMemorisation = BottomUpMemorisationApproach(dp,x,y,x.length(),y.length());
        System.out.println("Bottom Up Memorization Approach:- " + valuethroughBottomUpMemorisation);
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

    private static int BottomUpMemorisationApproach( int[][] dp, String x, String y, int i, int j) {
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        else if(x.charAt(i-1) == y.charAt(j-1)){
            return dp[i][j] = 1 + BottomUpMemorisationApproach(dp, x, y, i-1, j-1);
        }
        else{
            return dp[i][j] = Math.max(BottomUpMemorisationApproach(dp, x, y, i-1, j), BottomUpMemorisationApproach(dp, x, y, i, j-1));
        }
    }

    private static int RecursiveApproachLCS(String x, String y) {
        if(x.length() == 0 || y.length() == 0){
            return 0;
        }
        if(x.charAt(x.length()-1) == y.charAt(y.length()-1)){
            return 1+RecursiveApproachLCS(x.substring(0, x.length()-1), y.substring(0, y.length()-1));
        }else{
            return Math.max(RecursiveApproachLCS(x.substring(0, x.length()-1), y), RecursiveApproachLCS(x, y.substring(0, y.length()-1)));
        }
    }

    // O(n.n) space Optimised Solution
    /* 
    private static int LCS_Space_Optimised(String x, String y) {
        int[] cur = new int[y.length()+1];
        int[] prev = new int[y.length()+1];

        for(int i=1; i<=x.length(); i++){
            for(int j=1; j<= y.length(); j++){
                if(x.charAt(i) == y.charAt(j)){
                    cur[j]= 1+prev[j-1];
                }else{
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
        }
        return cur[y.length()];
    }

    // O(n) space Optimised Solution
    public static int LCSLength(String X, String Y)
    {
        int m = X.length(), n = Y.length();
 
        // allocate storage for one-dimensional array `curr`
        int[] curr = new int[n + 1];
        int prev;
 
        // fill the lookup table in a bottom-up manner
        for (int i = 0; i <= m; i++)
        {
            prev = curr[0];
            for (int j = 0; j <= n; j++)
            {
                int backup = curr[j];
                if (i == 0 || j == 0) {
                    curr[j] = 0;
                }
                else {
                    // if the current character of `X` and `Y` matches
                    if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                        curr[j] = prev + 1;
                    }
                    // otherwise, if the current character of `X` and `Y` don't match
                    else {
                        curr[j] = Integer.max(curr[j], curr[j - 1]);
                    }
                }
                prev = backup;
            }
        }
 
        // LCS will be the last entry in the lookup table
        return curr[n];
    }
    */
}
