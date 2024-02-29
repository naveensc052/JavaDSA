package Graphs;

import java.util.Arrays;
import java.util.Scanner;

// Leetcode Problem:- https://leetcode.com/problems/number-of-enclaves/description/  Problem Number:- 1020
public class NoOfEncaves {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] grid = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                grid[i][j] = scan.nextInt();
            }
        }
        System.out.println("Before:- ");
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        int ans = numEnclaves(grid);
        System.out.println("Answer:- " + ans);        
        scan.close();
    }
    public static int numEnclaves(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] a = {0};
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i==0 || j==0 || i == n-1 || j== m-1) && grid[i][j] == 1){
                    if(!visited[i][j]){
                        dfs(grid, i, j, visited, a);
                    }
                }
                if(grid[i][j] == 1){
                    ans++;
                }
                
            }
        }
        System.out.println(ans);
        System.out.println(a[0]);
        return ans - a[0];
    }

    public static void dfs(int[][] board, int i, int j, boolean[][] visited, int[] a){
        visited[i][j] = true;
        a[0]++;
        int n = board.length;
        int m = board[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dir:directions){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && board[ni][nj] == 1 && !visited[ni][nj]) {
                dfs(board, ni, nj, visited, a);
            }
        }
    }
}
