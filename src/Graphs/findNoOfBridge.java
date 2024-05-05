package Graphs;

import java.util.*;

public class findNoOfBridge {
	
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int V = scan.nextInt();
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			adj.add(new ArrayList<>());
		}
		while(true) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if(x == -1) break;
			
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		List<List<Integer>> ans = solve(V, adj);
		System.out.println(ans);
		scan.close();
	}

	private static List<List<Integer>> solve(int V, List<List<Integer>> adj) {
		List<List<Integer>> ans = new ArrayList<>();
		int[] time = new int[V + 1];
		int[] low = new int[V + 1];
		boolean[] visited = new boolean[V+1];
		int src = 1;
		dfs(src, adj, visited, time, low, ans, -1);
		return ans;
	}

	private static void dfs(int src, List<List<Integer>> adj, boolean[] visited, int[] time, int[] low, List<List<Integer>> ans, int par) {
		visited[src] = true;
		low[src] = time[src] = cnt++;
		for(int aNode: adj.get(src)) {
			
			if(aNode == par) continue;
			
			if(!visited[aNode]) {
				dfs(aNode, adj, visited, time, low, ans, src);
				low[src] = Math.min(low[src], low[aNode]);
				if(low[aNode] > time[src]) {
					List<Integer> temp = new ArrayList<>();
					temp.add(src);
					temp.add(aNode);
					ans.add(temp);
				}
				
			}else {
				low[src] = Math.min(low[src], low[aNode]);
			}
		}
	}

}
