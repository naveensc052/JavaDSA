package Graphs;

import java.util.ArrayList;
import java.util.List;

public class RepresentationUsingAdjacenyList {
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
    }
}
