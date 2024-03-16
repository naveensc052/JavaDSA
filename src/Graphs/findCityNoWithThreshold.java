package Graphs;

import java.util.Scanner;

public class findCityNoWithThreshold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] edges = new int[m][3];
		for(int i=0; i<m; i++) {
			edges[i][0] = scan.nextInt();
			edges[i][1] = scan.nextInt();
			edges[i][2] = scan.nextInt();
		}
		int threshold = scan.nextInt();
		int city = solve(n,m,edges, threshold);
		System.out.println(city);
		scan.close();
	}

	private static int solve(int n, int m, int[][] edges, int threshold) {
		int[][] matrix = new int[n][n];
		for(int i=0; i<m; i++) {
			matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
		}
		for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && matrix[i][j] == 0){
                    matrix[i][j] = 10000;
                }
            }
        }
		int via = 0;
        while(via<n){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j){
                        matrix[i][j] = 0;
                    }
                    else if(i == via || j == via){
                        continue;
                    }else{
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                    }
                }
            }
            via++;
        }
        int city = -1;
        int min = 100000;
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(i!=j && matrix[i][j] <= threshold){
                    cnt++;
                }
            }
            if(min >= cnt){
                city = i;
                min = cnt;
            }
        }
        return city;
	}

}
