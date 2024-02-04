package DynamicProgramming.KnapSack01;
public class knapsack {
	static int[][] dp1 = new int[101][1001];
	static int[][] dp2 = new int[101][101];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wt[] = {1,3,4,5};
		int v[] = {1,4,5,7};
		int W=10;
		int n=4;
		for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 1001; j++) {
                dp1[i][j] = -1;
            }
        }
		int ans = knapsackMemFun(wt,v,W,n);
		int answerusingRecursion = knapsackUsingrecursion(wt,v,W,n);
		int ansusingTopDown = knapsackUsingTopDown(wt,v,W,n);
		System.out.println("Using Memorization:- " + ans +"\nUsing Recursion:- " + answerusingRecursion + "\nUsing Topdown Approach:- " + ansusingTopDown);
	}
	private static int knapsackUsingTopDown(int[] wt, int[] v, int w, int n) {
		// TODO Auto-generated method stub
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=w; j++) {
				if(i == 0 || j == 0) {
					dp2[i][j] = 0;
				}
				else if(wt[i-1] <= j){
					dp2[i][j] = Math.max(v[i-1] + dp2[i-1][j-wt[i-1]], dp2[i-1][j]);
				}
				else {
					dp2[i][j] = dp2[i-1][j];
				}
			}
		}
		return dp2[n][w];
	}
	private static int knapsackUsingrecursion(int[] wt, int[] v, int W, int n) {
		// TODO Auto-generated method stub
		if(n == 0 || W == 0) {
			return 0;
		}
		if(wt[n-1]<=W) {
			return Math.max(v[n-1] + knapsackUsingrecursion(wt,v,W-wt[n-1],n-1), knapsackUsingrecursion(wt,v,W,n-1));
		}else {
			return knapsackUsingrecursion(wt,v,W,n-1);
		}
		
	}
	// Memorization Function
	public static int knapsackMemFun(int wt[],int v[],int W,int n) {
		if(n==0 || W==0) 
			return 0;
		if(dp1[n][W] != -1) 
			return dp1[n][W];
		if(wt[n-1]<=W) {
			return dp1[n][W] = Math.max(v[n-1]+knapsackMemFun(wt,v,W-wt[n-1],n-1),knapsackMemFun(wt,v,W,n-1));
		}
		else {
			return dp1[n][W] = knapsackMemFun(wt,v,W,n-1);
		}
	}

}
