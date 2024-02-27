package Graphs;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class EventualSafeNodeUsingBFS {
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
            adj.get(y).add(x); // Store in reverse instead For Using DFS using Kahn Algo
        }
        System.out.println(adj);
        List<Integer> list = solve(n, adj);
        System.out.println(list);
        scan.close();
    }

    private static List<Integer> solve(int n, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n+1];
        for(int i=1; i<=n; i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        for(int i=1; i<=n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int nod = q.poll();
            result.add(nod);
            for(int i:adj.get(nod)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
