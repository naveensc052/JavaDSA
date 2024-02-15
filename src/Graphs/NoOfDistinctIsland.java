package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NoOfDistinctIsland {
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
        boolean[][] visited = new boolean[n][m];
        HashSet<List<String>> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    List<String> list = new ArrayList<>();
                    bfs(grid, visited, i, j, i, j, list);
                    set.add(list);
                }
            }
        }
        System.out.println(set.size());
        scan.close();
    }

    private static void bfs(int[][] grid, boolean[][] visited, int i, int j, int i2, int j2, List<String> list) {
        
        Queue<PairList> q = new LinkedList<>();
        q.add(new PairList(i, j));
        while(!q.isEmpty()){
            PairList p = q.poll();
            int i1 = p.first;
            int j1 = p.second;
            visited[i1][j1] = true;
            int r = i1 - i2;
            int c = j1 - j2;
            String s = r + "|" + c;
            list.add(s);
            int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
            for(int[] dir: directions){
                int ni = i1 + dir[0];
                int nj = j1 + dir[1];
                if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && !visited[ni][nj] && grid[ni][nj] == 1){
                    q.add(new PairList(ni, nj));
                }
            }
            
        }
        System.out.println(list);
    }
}
