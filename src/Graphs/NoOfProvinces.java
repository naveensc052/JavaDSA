package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoOfProvinces {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter the vertices where all the Edges are present else enter -1 and -1..");
        while (true) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(x == -1){
                break;
            }
            else{
                adj.get(x).add(y);
                adj.get(y).add(x);
            }
        }

        System.out.println("Given Graph is :-");
        for (int i = 1; i <= n; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        boolean[] visited = new boolean[n+1];
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                Solution(adj, visited, i);
                ans++;
            }
        }
        
        System.out.println(ans);
        scan.close();
    }
    private static void Solution(List<List<Integer>> adj, boolean[] visited, int src) {
        visited[src] = true;
        for(int i: adj.get(src)){
            if(!visited[i]){
                Solution(adj, visited, i);
            }
        }
    }
}
