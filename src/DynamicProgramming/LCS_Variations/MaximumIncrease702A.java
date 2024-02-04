package DynamicProgramming.LCS_Variations;

import java.util.Scanner;

public class MaximumIncrease702A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scan.nextInt();
        }
        int ans = solve(nums, n, 0);
        System.out.println(ans);
        scan.close();
    }

    private static int solve(int[] nums, int n, int prev) {
        int max = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(prev < nums[i]){
                prev = nums[i];
                count++;
                max = Math.max(max, count);
            }else{
                count = 1;
                prev = nums[i];
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
