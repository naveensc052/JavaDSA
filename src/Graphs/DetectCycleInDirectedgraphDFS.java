package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class DetectCycleInDirectedgraphDFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter the vertices where all the Edges are present else enter -1 and -1..");
        while (true) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(x == -1){
                break;
            }
            else{
                adj.get(x).add(y);
            }
        }
        boolean[] visited = new boolean[n+1];
        HashSet<Integer> set = new HashSet<>();
        boolean[] ans = {false};
        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                dfs(adj, visited, i, set, ans);
            }
        }
        System.out.println(ans[0]); // true is Cycle is present else false
        scan.close();
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited, int src, HashSet<Integer> set, boolean[] ans) {
        visited[src] = true;
        set.add(src);
        for(int i:adj.get(src)){
            if(!visited[i] && !set.contains(i) && !ans[0]){
                dfs(adj, visited, i, set, ans);
            }else{
                if(visited[i])
                    ans[0] = true;
            }
        }
        visited[src] = false;
    }
}
