package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Leetcode problem 1091:- https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

class tuple{
    int r;
    int c;
    int d;
    tuple(int d, int r, int c){
        this.d = d;
        this.r = r;
        this.c = c;
    }
}

public class ShortestPathInBinaryMaze {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] grid = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = scan.nextInt();
			}
		}
		int ans = shortestPathBinaryMatrix(grid);
		System.out.println(ans);
		scan.close();
	}

	private static int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
        Queue<tuple> q = new LinkedList<>();
        int[] row = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] col = {-1, 0, 1, 1, 1, 0, -1, -1};
        if(grid[0][0] == 0){
            q.add(new tuple(1,0,0));
            grid[0][0] = 1;
        }
        while(!q.isEmpty()){
            tuple node = q.poll();
            if(node.r == node.c && node.c == n-1){
                return node.d;
            }
            for(int i=0; i<8; i++){
                int nr = node.r + row[i];
                int nc = node.c + col[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 0){
                    q.add(new tuple(node.d + 1, nr, nc));
                    grid[nr][nc] = 1;
                }
            }
        }
        return -1;
	}

}
