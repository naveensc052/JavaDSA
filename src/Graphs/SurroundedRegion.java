package Graphs;

import java.util.Arrays;
import java.util.Scanner;

// Leetcode Problem:- https://leetcode.com/problems/surrounded-regions/description/ Problem Number:- 130
public class SurroundedRegion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                grid[i][j] = scan.next().charAt(0);
            }
        }
        System.out.println("Before:- ");
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        solve(grid);
        System.out.println("After:- ");
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        scan.close();
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j==0 || i == n-1 || j== m-1){
                    if(board[i][j] == 'X'){
                        visited[i][j] = true;
                    }else{
                        dfs(board, i, j, visited);
                    }
                }else if(board[i][j] == 'X'){
                    visited[i][j] = true;
                }
            }
        }
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(visited[i][j] == false){
                    board[i][j] = 'X';
                }

    }

    public static void dfs(char[][] board, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        int n = board.length;
        int m = board[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dir:directions){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && board[ni][nj] == 'O') {
                if (!visited[ni][nj]) {
                    dfs(board, ni, nj, visited);
                }
            }
        }
    }
}
