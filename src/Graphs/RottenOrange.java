package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    int row;
    int col;
    int time;
    Pair(int r, int c, int t){
        this.row = r;
        this.col = c;
        this.time = t;
    }
}

public class RottenOrange {
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
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            Pair nod = q.poll();
            int row = nod.row;
            int col = nod.col;
            int time = nod.time;
            ans = Math.max(ans, time);
            if(row>0 && grid[row-1][col] == 1 && visited[row-1][col] != 2){
                q.add(new Pair(row-1, col, time+1));
                visited[row-1][col] = 2;
            }
            if(row<n-1 && grid[row+1][col] == 1 && visited[row+1][col] != 2){
                q.add(new Pair(row+1, col, time+1));
                visited[row+1][col] = 2;
            }
            if(col>0 && grid[row][col-1] == 1 && visited[row][col-1] != 2){
                q.add(new Pair(row, col-1, time+1));
                visited[row][col-1] = 2;
            }
            if(col<m-1 && grid[row][col+1] == 1 && visited[row][col+1] != 2){
                q.add(new Pair(row, col+1, time+1));
                visited[row][col+1] = 2;
            }
        }
        System.out.println("Time Required is " + ans);

    }
}
