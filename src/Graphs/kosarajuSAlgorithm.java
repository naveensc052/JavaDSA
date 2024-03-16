package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class kosarajuSAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int max = -1;
		int[][] edges = new int[n][2];
		for(int i=0; i<n; i++) {
			edges[i][0] = scan.nextInt();
			edges[i][1] = scan.nextInt();
			max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
		}
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0; i<max+1; i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0; i<n; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
		}
		List<List<Integer>> list = solve(adj, max + 1);
		System.out.println(list);
		scan.close();
	}

	private static List<List<Integer>> solve(List<List<Integer>> adj, int V) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<>();
		int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (Integer it : adj.get(i)) {
                // i -> it
                // it -> i
                adjT.get(it).add(i);
            }
        }
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {
                scc++;
                List<Integer> com = new ArrayList<>();
                dfs3(node, vis, adjT, com);
                list.add(com);
            }
        }
        System.out.println(scc);
        return list;
	}

	private static void dfs(int node, int []vis, List<List<Integer>> adj, Stack<Integer> st) {
		vis[node] = 1;
		for (Integer it : adj.get(node)) {
		   if (vis[it] == 0) {
		       dfs(it, vis, adj, st);
		   }
		}
		st.push(node);
	}

	private static void dfs3(int node, int[] vis, List<List<Integer>> adjT, List<Integer> com) {
        vis[node] = 1;
        com.add(node);
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, adjT, com);
            }
        }
    }
}
