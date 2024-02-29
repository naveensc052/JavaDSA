package Graphs;

import java.util.*;

class Node{
    int src;
    int prev;
    Node(int s, int p){
        this.src = s;
        this.prev = p;
    }
}

public class DetectingPresenceOfCycle {
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
        boolean present = false;
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                if(isCyclePresentUsingBFS(adj, visited, i)){
                    present = true;
                    i = n;
                }
            }
        }
        if(present){
            System.out.println("Cyclic graph");
        }else{
            System.out.println("Ayclic graph");
        }

        boolean p = false;
        boolean[] visit= new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                if(isCyclePresentUsingDFS(adj, visit, i, -1)){
                    p = true;
                    i = n;
                }
            }
        }
        if(p){
            System.out.println("Cyclic graph");
        }else{
            System.out.println("Ayclic graph");
        }
        scan.close();
    }

    private static boolean isCyclePresentUsingDFS(List<List<Integer>> adj, boolean[] visit, int src, int prev) {
        visit[src] = true;
        for (int neighbor : adj.get(src)) {
            if (!visit[neighbor]) {
                if (isCyclePresentUsingDFS(adj, visit, neighbor, src)) {
                    return true;
                }
            }else if (neighbor != prev) {
                return true;
            }
        }
        return false;
    }
    

    private static boolean isCyclePresentUsingBFS(List<List<Integer>> adj, boolean[] visited, int s) {
        Queue<Node> q = new LinkedList<>();
        visited[s] = true;
        q.add(new Node(s, -1));
        while(!q.isEmpty()){
            Node e = q.poll();
            int prev = e.prev;
            int cur = e.src;
            for(int i : adj.get(cur)){
                if(!visited[i]){
                    q.add(new Node(i, cur));
                    visited[i] = true;
                }else if( i != prev){
                    return true;
                }
            }
        }
        
        return false;
    }
}
