package Graphs;


// Leetcode Problem:-  https://leetcode.com/problems/course-schedule/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CourseSchedule1 {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        while(true){
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(x == -1){
                break;
            }
            adj.get(x).add(y);
        }
        System.out.println(adj);
        boolean ans = solve(n, adj);
        System.out.println(ans);
        scan.close();
    }

    private static boolean solve(int n, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int nod = q.poll();
            cnt++;
            for(int i:adj.get(nod)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return cnt == n ? true:false;
    }
}
