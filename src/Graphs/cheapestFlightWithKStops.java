package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;

class tupleForKstops{
    int first;
    int second;
    int stops;
    tupleForKstops(int f, int s, int k){
        this.first = f;
        this.second = s;
        this.stops = k;
    }
}
class PairForKstops{
    int first;
    int second;
    PairForKstops(int f, int s){
        this.first = f;
        this.second = s;
    }
}
public class cheapestFlightWithKStops {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] grid = new int[n][3];
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				grid[i][j] = scan.nextInt();
			}
		}
		int src = scan.nextInt(); // Input Source
		int dst = scan.nextInt(); // Input Destination
		int k = scan.nextInt(); // Input Stops
		int ans = findCheapestPrice(n, grid, src, dst, k);
		System.out.println(ans);
		scan.close();

	}
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		List<List<PairForKstops>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new PairForKstops(flights[i][1],flights[i][2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<tupleForKstops> pq = new PriorityQueue<>((x,y) -> x.stops-y.stops);
        pq.add(new tupleForKstops(0, src, 0));
        while(!pq.isEmpty()){
            tupleForKstops node = pq.poll();
            if(node.stops > k) continue;

            for(PairForKstops curN:adj.get(node.second)){
                if(dist[curN.first] > node.first + curN.second && node.stops <= k+1){
                    pq.add(new tupleForKstops(node.first + curN.second, curN.first, node.stops+1));
                    dist[curN.first] = node.first + curN.second;
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE?-1:dist[dst];
    }
}
