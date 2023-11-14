package DynamicProgramming;
public class knapsack {
	static int[][] dp = new int[101][1001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wt[] = {1,3,4,5};
		int v[] = {1,4,5,7};
		int W=10;
		int n=4;
		for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }
		int ans = knapsackfun(wt,v,W,n);
		System.out.println(ans);
	}
	public static int knapsackfun(int wt[],int v[],int W,int n) {
		if(n==0 || W==0) return 0;
		if(dp[n][W] != -1) return dp[n][W];
		if(wt[n-1]<=W) {
			return dp[n][W] = max(v[n-1]+knapsackfun(wt,v,W-wt[n-1],n-1),knapsackfun(wt,v,W,n-1));
		}
		else {
			return dp[n][W] = knapsackfun(wt,v,W,n-1);
		}
	}
	static int max(int a,int b) {
		return a>b?a:b;
	}

}
