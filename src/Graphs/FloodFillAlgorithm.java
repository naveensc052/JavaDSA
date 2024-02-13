package Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class FloodFillAlgorithm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] grid = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = scan.nextInt();
            }
        }
        int sr = scan.nextInt();
        int sc = scan.nextInt();
        int newColor = scan.nextInt();
        boolean[][] visited = new boolean[n][m];
        System.out.println("Before Flooding:- ");
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        dfs(grid, sr, sc, newColor, visited);
        System.out.println("After Flooding:- ");
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        scan.close();
    }

    


    public static void dfs(int[][] image, int sr, int sc, int newColor, boolean[][] visited){
        visited[sr][sc] = true;
        int c = image[sr][sc];
        image[sr][sc] = newColor;
        if(sr>0 && !visited[sr-1][sc] && image[sr-1][sc] == c){
            dfs(image, sr-1, sc, newColor, visited);
        }
        if(sr<image.length-1 && !visited[sr+1][sc] && image[sr+1][sc] == c){
            dfs(image, sr+1, sc, newColor, visited);
        }
        if(sc>0 && !visited[sr][sc-1] && image[sr][sc-1] == c){
            dfs(image, sr, sc-1, newColor, visited);
        }
        if(sc<image[0].length-1 && !visited[sr][sc+1] && image[sr][sc+1] == c){
            dfs(image, sr, sc+1, newColor, visited);
        }
    }
}
