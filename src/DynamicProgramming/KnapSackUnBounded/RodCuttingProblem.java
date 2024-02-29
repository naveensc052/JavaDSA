package DynamicProgramming.KnapSackUnBounded;
/*
 * UnBounded KnapSack Problem
 */
import java.util.Scanner;

public class RodCuttingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// Size of the length
		int n = scan.nextInt();
		// Size of Cut points
		int m = scan.nextInt();
		int[] price = new int[n];
		int[] length = new int[n];
		//Input price Array
		for(int i=0; i<n; i++){
			int num1 = scan.nextInt();
			price[i] = num1;
		}
		//Input Cut points
		for(int i=0; i<m; i++){
			int num2 = scan.nextInt();
			length[i] = num2;
		}
		System.out.println(rodcuttingproblem(length,price,n,m));
		scan.close();
	}

	private static int rodcuttingproblem(int[] length, int[] price, int n, int m) {
		int[][] dp = new int[m+1][n+1];
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(j>length[i-1]){
					dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]],dp[i-1][j]);
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[m][n];
	}
}
