package Graphs;

import java.util.*;
class tupleMST{
	int first;
	int second;
	int par;
	tupleMST(int f, int s, int p){
		this.first = f;
        this.second = s;
        this.par = p;
	}
}
class PairSP{
    int first;
    int second;
    PairSP(int f, int s){
        this.first = f;
        this.second = s;
    }
}
public class minimumSpanningTree {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int e = scan.nextInt();
		int[][] edges = new int[e][3];
		for(int i=0; i<e; i++) {
			edges[i][0] = scan.nextInt();
			edges[i][1] = scan.nextInt();
			edges[i][2] = scan.nextInt();
		}
		int ans = spanningTree(n,e,edges);
		System.out.println("Minimum Weight is " + ans);
		scan.close();
	}
	public static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    PriorityQueue<tupleMST> pq = new PriorityQueue<>((x,y) -> x.first - y.first);
	    List<List<PairSP>> adj = new ArrayList<>();
	    for(int i=0; i<V; i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0; i<E; i++){
	        adj.get(edges[i][0]).add(new PairSP(edges[i][1], edges[i][2]));
	        adj.get(edges[i][1]).add(new PairSP(edges[i][0], edges[i][2]));
	    }
	    pq.add(new tupleMST(0,0,-1));
	    boolean[] visited = new boolean[V];
	    
	    int ans = 0;
	    List<PairSP> list = new ArrayList<>();
	    while(!pq.isEmpty()){
	    	tupleMST cur = pq.poll();
	        if(!visited[cur.second]){
	            ans += cur.first;
	            visited[cur.second] = true;
	            if(cur.par != -1) {
	            	list.add(new PairSP(cur.second, cur.par));
	            	System.out.println(cur.second + " --> " + cur.par);
	            }
	            for(PairSP adjNode:adj.get(cur.second)){
    	            if(!visited[adjNode.first]){
    	                pq.add(new tupleMST(adjNode.second, adjNode.first,cur.second ));
    	            }
    	        }
	        }
	        
	    }
	    return ans;
	}
}
