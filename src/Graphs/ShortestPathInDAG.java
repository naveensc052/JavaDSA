package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ShortestPathInDAG {
    public static void main(String[] args) {
        List<List<PairList>> adj = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        while(true){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int wt = scan.nextInt();
            if(x == -1){
                break;
            }
            adj.get(x).add(new PairList(y, wt));
        }
        System.out.println(adj);
        int[] dist = solve(n, adj);
        System.out.println(Arrays.toString(dist));
        scan.close();
    }

    private static int[] solve(int n, List<List<PairList>> adj) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i, adj, visited, s);
            }
        }
        dist[1] = 0; // src is 1
        while (!s.isEmpty()) {
            int node = s.pop();

            for (int i = 0; i < adj.get(node).size(); i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if (dist[node] + wt < dist[v]){
                    dist[v] = wt + dist[node];
                }
            }
        }
        return dist;
    }

    private static void dfs(int i, List<List<PairList>> adj, boolean[] visited, Stack<Integer> s) {
        visited[i] = true;
        for(PairList nod : adj.get(i)){
            if(!visited[nod.first]){
                dfs(nod.first, adj, visited, s);
            }
        }
        s.add(i);
    }
}
