package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        /*
        * 
        *       | 1 | ------- | 2 |
        *         |             |    \
        *         |             |      \
        *         |             |         | 5 |
        *         |             |     /
        *         |             |   /
        *       | 3 | ------- | 4 |
        */


        // Adding n+1 new ArrayList to adj
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        // For Edge between 1 and 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // For Edge between 1 and 3
        adj.get(1).add(3);
        adj.get(3).add(1);

        // For Edge between 3 and 4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // For Edge between 2 and 4
        adj.get(2).add(4);
        adj.get(4).add(2);

        // For Edge between 2 and 5
        adj.get(2).add(5);
        adj.get(5).add(2);

        // For Edge between 4 and 5
        adj.get(4).add(5);
        adj.get(5).add(4);

        // Print the adjacency list
        for (int i = 1; i <= n; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        int src = 4;
        bfs(adj, src, n);
    }

    private static void bfs(List<List<Integer>> adj, int src, int n) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(src);
        visited[src] = true;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            list.add(node);
            for(int i: adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println("Traversal: - " + list);
    }
}
