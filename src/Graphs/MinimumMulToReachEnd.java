package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PairMinMul{
	int val;
	int steps;
	PairMinMul(int v, int s){
		this.steps = s;
		this.val = v;
	}
}
public class MinimumMulToReachEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		int start = scan.nextInt();
		int end = scan.nextInt();
		int ans = minimumMultiplications(arr, start, end);
		System.out.println(ans);
		scan.close();
	}
	public static int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if(start == end) return 0;
        Queue<PairMinMul> q = new LinkedList<>();
        q.add(new PairMinMul(start,0));
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while(!q.isEmpty()){
            PairMinMul node = q.poll();
            int nod = node.val;
            int steps = node.steps;
            for(int i=0; i<arr.length; i++){
                int num = (arr[i]*nod)%100000;
                if(steps + 1 < dist[num]){
                    dist[num] = steps + 1;
                    if(num == end) return steps + 1; 
                    q.add(new PairMinMul(num, steps + 1));
                }
            }
        }
        return -1;
    }
}
