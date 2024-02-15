package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CheckForBipartite {
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
                adj.get(y).add(x);
            }
        }
        boolean[] ans = {true};
        boolean[] visited = new boolean[n+1];
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);
        dfs(adj, visited, 1, ans, 0, colors);
        if(ans[0]){
            System.out.println("It is a Bipartite Graph");
        }else{
            System.out.println("It is NOT A BIPARTITE GRAPH");
        }
        scan.close();
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited, int src, boolean[] ans, int color, int[] colors) {
        visited[src] = true;
        colors[src] = color;
        for(int i:adj.get(src)){
            if(!visited[i] && ans[0]){
                dfs(adj, visited, i, ans, color == 0 ? 1:0 , colors);
            }else{
                if(colors[i] == color){
                    ans[0] = false;
                    break;
                }
            }
        }
    }

    
}
