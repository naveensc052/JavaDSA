package Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class floydWarshallAlgorithm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] matrix = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int x = scan.nextInt();
				if(i==j) continue;
				if(x == -1) {
					matrix[i][j] = 10001;
				}else {
					matrix[i][j] = x;
				}
			}
		}
		System.out.println("Before:-");
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		shortest_distance(matrix);
		System.out.println("After:-");
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		scan.close();
	}
	
	
	public static void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -1){
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
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] >= 1001){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
