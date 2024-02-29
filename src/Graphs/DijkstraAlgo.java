package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<List<PairList>> adj = new ArrayList<>();
		for(int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		while(true) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int wt = scan.nextInt();
			if(x == -1) break;
			adj.get(x).add(new PairList(y,wt));
			adj.get(y).add(new PairList(x,wt));
		}
		System.out.println(adj);
		int[] dist = solve(n, adj);
		System.out.println(Arrays.toString(dist));
		scan.close();
	}

	private static int[] solve(int n, List<List<PairList>> adj) {
		// TODO Auto-generated method stub
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int src = 0;
		dist[src] = 0;
		
		PriorityQueue<PairList> pq = new PriorityQueue<PairList>((x,y) -> x.first - y.first);
		pq.add(new PairList(0,src));
		while(pq.size() != 0) {
            int dis = pq.peek().first; 
            int node = pq.peek().second; 
            pq.remove(); 
            
            // Check for all adjacent nodes of the popped out
            // element whether the prev dist is larger than current or not.
            for(PairList nod: adj.get(node)) {
                int edgeWeight = nod.second; 
                int adjNode = nod.first; 
                
                // If current distance is smaller,
                // push it into the queue.
                if(dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight; 
                    pq.add(new PairList(dist[adjNode], adjNode)); 
                }
            }
        }
		
		
		for(int i=0; i<n; i++) {
			dist[i] = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
		}
		return dist;
	}

}
