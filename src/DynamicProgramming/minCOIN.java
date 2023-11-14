package DynamicProgramming;

import java.util.Arrays;

public class minCOIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {25,10,1};
		int n=48;
		int dp[] = new int [n+1];
		Arrays.fill(dp, -1);
		dp[0]=0;
		
		System.out.println(mincoins(n,a,dp)+"\n\n");
		for(int x:dp) {
			System.out.println(x);
		}
	}
	
	public static int mincoins(int n, int a[],int dp[]) {
		if(n==0) return 0;
		int ans=Integer.MAX_VALUE;
		for(int i=0; i<a.length; i++) {
			
			if(n-a[i] >= 0) {
				int subans = 0;
				if(dp[n-a[i]] != -1) {
					subans=dp[n-a[i]];
				}
				else {
					subans = mincoins(n-a[i],a,dp);
				}
				
				if(subans != Integer.MAX_VALUE && subans+1<ans)
					ans=subans+1;
			}
		}
		return dp[n]=ans;
	}
}
