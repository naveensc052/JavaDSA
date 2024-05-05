package Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class bellmanFordAlgorithm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] edges = new int[m][3];
		for(int i=0; i<m; i++) {
			edges[i][0] = scan.nextInt();
			edges[i][1] = scan.nextInt();
			edges[i][2] = scan.nextInt();
		}
		int src = scan.nextInt();
		int[] dist = solve(n,m,edges,src);
		System.out.println(Arrays.toString(dist));
		scan.close();
	}

	private static int[] solve(int n, int m, int[][] edges, int src) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int[] pred = new int[n];
		Arrays.fill(pred, src);
		dist[src] = 0;
		int count = 1;
		while(count < n) {
			for(int i=0; i<m; i++) {
				int s = edges[i][0];
				int d = edges[i][1];
				int wt = edges[i][2];
				if(dist[s] + wt < dist[d]) {
					dist[d] = dist[s] + wt;
					pred[d] = s;
				}
			}
			count++;
		}
		System.out.println(Arrays.toString(pred));
		for(int i=0; i<n; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				dist[i] = -1;
			}
		}
		return dist;
	}

}
