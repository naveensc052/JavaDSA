package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// Letcode Problem 1976:- https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

class PairNoVAD{ // Pair for No of values to Arrive Destination
	int first;
	int second;
	PairNoVAD(int f, int s){
		this.first = f;
		this.second = s;
	}
}
public class noOfValuesToArriveDest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<List<PairNoVAD>> adj = new ArrayList<>();
		for(int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		while(true) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int wt = scan.nextInt();
			
			if(x == -1) break;
			
			adj.get(x).add(new PairNoVAD(y,wt));
			adj.get(y).add(new PairNoVAD(x,wt));
		}
		
		int ans = countPaths(n, adj);
		System.out.println(ans);
		scan.close();
	}

	private static int countPaths(int n, List<List<PairNoVAD>> adj) {
		int[] time = new int[n];
		int[] ways = new int[n];
		Arrays.fill(time, Integer.MAX_VALUE);
		time[0] = 0;
		ways[0] = 1;
		PriorityQueue<PairNoVAD> pq = new PriorityQueue<>((x,y) -> x.first - y.first);
		pq.add(new PairNoVAD(0,0));
		while(!pq.isEmpty()) {
			PairNoVAD curNode = pq.poll();
			int curN = curNode.second;
			int curTime = curNode.first;
			for(PairNoVAD adjNode: adj.get(curN)) {
				int nextNode = adjNode.first;
				int nextTime = curTime + adjNode.second;
				if(nextTime < time[nextNode]) {
					time[nextNode] = nextTime;
					pq.add(new PairNoVAD(nextTime, nextNode));
					ways[nextNode] = ways[curN];
				}else if (nextTime == time[nextNode]) {
					ways[nextNode] = (ways[nextNode] + ways[curN]) % 700000000;
				}
			}
		}
		return ways[n-1];
	}

}
