package Graphs;

import java.util.*;

public class articulationNodesOnGraphs {
	private static int timer = 1;
    private static void dfs(int node, int parent, int[] vis,
                     int tin[], int low[], int[] mark,
                     List<List<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }
    //Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> articulationPoints(int V,List<List<Integer>> adj)
    {
        // Code here
        int n =V;
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		ArrayList<Integer> ans = articulationPoints(V, adj);
		System.out.println(ans);
		scan.close();
	}

}
