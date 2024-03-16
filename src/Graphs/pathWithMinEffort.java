package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;



public class pathWithMinEffort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] grid = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = scan.nextInt();
			}
		}
		int ans = minimumEffortPath(grid);
		System.out.println(ans);
		scan.close();
	}
	
	public static int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        int[] row = {0, 1, 0, -1};
        int[] col = {1, 0, -1, 0};
        PriorityQueue<tuple> q = new PriorityQueue<>((x,y) -> x.d-y.d);
        q.add(new tuple(0, 0, 0));
        while(!q.isEmpty()){
            tuple node = q.poll();
            int dif = node.d;
            if(node.r == n-1 && node.c == m-1) return dif;
            for(int i=0; i<4; i++){
                int nr = node.r + row[i];
                int nc = node.c + col[i];
                
                if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length){
                    int newEffort = Math.max(Math.abs(heights[nr][nc] - heights[node.r][node.c]), dif);
                    if(newEffort < dist[nr][nc]){
                        q.add(new tuple(newEffort, nr, nc));
                        dist[nr][nc] = newEffort;
                    }
                }
            }
        }
        return 0;
    }
}
