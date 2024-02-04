package DynamicProgramming.LCS_Variations;

import java.util.Scanner;

public class LonComSubstring {
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
        int MaxLen = Integer.MIN_VALUE;
        for(int i=1; i<=x.length(); i++){
            for(int j=1; j<=y.length(); j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
                MaxLen = Math.max(MaxLen, dp[i][j]);
            }
        }
        return MaxLen;
    }
}
