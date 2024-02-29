package DynamicProgramming.MatrixChainMultiplication;

import java.util.Scanner;

public class LastYearsSubstring1426B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int t = 0; t < testCases; t++){
            int n = scan.nextInt();
            String s = scan.next();
            boolean[] ans = new boolean[1];
            solve(n,s,ans,0,n-1);
            if(ans[0]){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static void solve(int n, String s, boolean[] ans, int i, int j) {
        if(j-i<4){
            return;
        }
        if(j-i == 3 && s.substring(i, j+1).equals("2020")){
            ans[0] = true;
        }else{
            for(int k=i; k<j; k++){
                solve(n, s, ans, i, k);
                solve(n, s, ans, k+1, j);
            }
        }
    }
}
