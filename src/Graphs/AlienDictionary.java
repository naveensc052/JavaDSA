package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class AlienDictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        String[] dict = new String[N];
        for(int i=0; i<N; i++){
            dict[i] = scan.next();
        }
        String s = findOrder(dict, N, K);
        System.out.println(s);
        scan.close();
    }

    public static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++){
            for(int j=0; j<Math.min(dict[i].length(), dict[i+1].length()); j++){
                if(dict[i].charAt(j) != dict[i+1].charAt(j)){
                    adj.get(dict[i].charAt(j) - 'a').add(dict[i+1].charAt(j) - 'a');
                    break;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[K];
        for(int i=0; i<K; i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        for(int i=0; i<K; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!q.isEmpty()){
            int node = q.poll();
            str.append(Character.toString(node + 'a'));
            for(int i:adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return str.toString();
    }
}
