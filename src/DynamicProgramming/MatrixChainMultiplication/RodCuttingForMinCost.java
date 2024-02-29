package DynamicProgramming.MatrixChainMultiplication;

import java.util.Scanner;

public class RodCuttingForMinCost {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Length of the Rod
        int n = scan.nextInt();
        int cutlength = scan.nextInt();
        int[] cut = new int[cutlength+2];
        for(int i=0; i<cutlength; i++){
            int c = scan.nextInt();
            cut[i+1] = c;
        }
        cut[cutlength+1] = n;
        System.out.println(minCostForRodCutting(cut,0,cutlength+1));
        scan.close();
    }

    private static int minCostForRodCutting(int[] cut, int i, int n) {
        if(i+1 >= n){
            return 0;
        }
        else{
            int min = Integer.MAX_VALUE;
            for(int j = i+1; j<n; j++){
                int val = minCostForRodCutting(cut, i, j) + minCostForRodCutting(cut, j, n) + cut[n] - cut[i];
                min = Math.min(min, val);
            }
            return min;
        }
        
    }
}
