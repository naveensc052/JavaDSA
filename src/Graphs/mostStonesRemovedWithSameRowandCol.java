package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mostStonesRemovedWithSameRowandCol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] stones = new int[n][2];
		int maxrow = 0;
		int maxcol = 0;
		for(int i=0; i<n; i++) {
			int r = scan.nextInt();
			int c = scan.nextInt();
			stones[i][0] = r;
			stones[i][1] = c;
			if(maxrow < r + 1) {
				maxrow = r + 1;
			}
			if(maxcol < c  + 1) {
				maxcol = c + 1;
			}
		}
		int[][] grid = new int[maxrow][maxcol];
		int cnt = 1;
		for(int i=0; i<n; i++) {
			grid[stones[i][0]][stones[i][1]] = cnt++;
		}
		int ans = solve(n, grid);
		System.out.println(ans);
		scan.close();
	}

	private static int solve(int n, int[][] grid) {
		DisjointSet ds = new DisjointSet(n);
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] != 0) {
					for(int r=0; r<grid.length; r++) {
						if(i!=r && grid[r][j] != 0 ) {
							ds.unionByRank(grid[i][j] ,grid[r][j]);
						}
					}
					for(int c=0; c<grid[0].length; c++) {
						if(j!=c && grid[i][c] != 0 ) {
							ds.unionByRank(grid[i][j] ,grid[i][c]);
						}
					}
				}
			}
		}
		int ans = 0;
		for(int i=1; i<=n; i++) {
			if(ds.findUPar(i) == i) {
				ans++;
			}
		}
		return n-ans;
	}
	// optimised Memory
	public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n - cnt;
    }
}
