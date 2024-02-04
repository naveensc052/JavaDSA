package DynamicProgramming.MatrixChainMultiplication;

import java.util.Scanner;

public class EggDroppingProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int egg = scan.nextInt();
        int floor = scan.nextInt();
        System.out.println(solve(egg,floor));
        scan.close();
    }

    private static int solve(int egg, int floor) {
        if(egg == 0 || floor == 1 || egg == 1 || floor == 0){
            return floor;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=floor; i++){
            int temp = 1 + Math.max(solve(egg-1,i-1), solve(egg, floor-i));
            min = Math.min(min, temp);
        }
        return min;
    }
}
