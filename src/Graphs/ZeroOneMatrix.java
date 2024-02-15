package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair1 {
    int r, c, v;

    Pair1(int r, int c, int v) {
        this.r = r;
        this.c = c;
        this.v = v;
    }
}

public class ZeroOneMatrix {

    public static void main(String[] args) {
        // Example usage of the Solution class
        int[][] matrix = {
            {0, 1, 1},
            {0, 1, 1},
            {0, 1, 1}
        };

        Solution solution = new Solution();
        int[][] result = solution.updateMatrix(matrix);

        // Print the result or perform further operations
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] distance = new int[n][m];
        Queue<Pair1> q = new LinkedList<>();

        // Add all 0 cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair1(i, j, 0));
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            Pair1 nod = q.poll();
            int i = nod.r;
            int j = nod.c;
            int v = nod.v;

            // Check all four directions
            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                // Check if the new position is within bounds
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1) {
                    // If not visited, mark it as visited and add to the queue
                    if (distance[ni][nj] == 0) {
                        distance[ni][nj] = v + 1;
                        q.add(new Pair1(ni, nj, v + 1));
                    }
                }
            }
        }

        return distance;
    }
}