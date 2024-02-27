package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        while(true){
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(x == -1){
                break;
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        List<Integer> ans = solve(adj,n);
        System.out.println(ans);
        scan.close();
    }

    private static List<Integer> solve(List<List<Integer>> adj, int n) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i, adj, visited, stack);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private static void dfs(int i, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for(int node:adj.get(i)){
            if(!visited[node]){
                dfs(node, adj, visited, stack);
            }
        }
        stack.push(i);
    }
}
