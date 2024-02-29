package DynamicProgramming.KnapSack01;

import java.util.Scanner;

public class FairDivisionOfCandies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0; i<t; i++){
            int n = scan.nextInt();
            int[] candies = new int[n];
            int sum = 0;
            for(int j = 0; j<n; j++){
                candies[j] = scan.nextInt();
                sum += candies[j];
            }
            if(sum%2 == 1){
                System.out.println("NO");
                continue;
            }
            else{
                sum = sum/2;
                boolean[][] dp = new boolean[n+1][sum+1];
                for(int j=0; j<=n; j++){
                    dp[j][0] = true;
                }
                for(int j=1; j<=n; j++){
                    for(int k = 1; k<=sum; k++){
                        if(k >= candies[j-1]){
                            dp[j][k] = dp[j-1][k] || dp[j-1][k-candies[j-1]];
                        }else{
                            dp[j][k] = dp[j-1][k];
                        }
                    }
                }
                if(dp[n][sum]){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
