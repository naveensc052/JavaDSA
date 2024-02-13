package Graphs;

import java.util.Scanner;

public class NoOfIslands {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = (char)scan.nextInt();
            }
        }

        int ans = numIslands(grid);
        System.out.println(ans);
        scan.close();
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    ans++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return ans;
    }

    public static void dfs(char[][] grid, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        if(i>0 && !visited[i-1][j] && grid[i-1][j] == '1')
            dfs(grid, visited, i-1, j);
        if(i<grid.length-1 && !visited[i+1][j] && grid[i+1][j] == '1')
            dfs(grid, visited, i+1, j);
        if(j>0 && !visited[i][j-1] && grid[i][j-1] == '1')
            dfs(grid, visited, i, j-1);
        if(j<grid[0].length-1 && !visited[i][j+1] && grid[i][j+1] == '1')
            dfs(grid, visited, i, j+1);
    }
}
