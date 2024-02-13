package Graphs;

public class RepresentationUsingAdjacency {
    public static void main(String[] args) {
        int n = 5;
        int[][] adj = new int[n+1][n+1];
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
        
        // Note:- for weighted graph instead of storing 1 store the weight it self

        // For Edge between 1 and 2
        adj[1][2] = 1;
        adj[2][1] = 1;

        // For Edge between 1 and 3
        adj[1][3] = 1;
        adj[3][1] = 1;

        // For Edge between 3 and 4
        adj[3][4] = 1;
        adj[4][3] = 1;

        // For Edge between 2 and 4
        adj[2][4] = 1;
        adj[4][2] = 1;

        // For Edge between 2 and 5
        adj[2][5] = 1;
        adj[5][2] = 1;

        // For Edge between 4 and 5
        adj[4][5] = 1;
        adj[5][4] = 1;

    }
}
