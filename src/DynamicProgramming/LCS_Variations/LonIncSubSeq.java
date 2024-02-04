package DynamicProgramming.LCS_Variations;

import java.util.Scanner;

public class LonIncSubSeq {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        int size = scan.nextInt();
        int[] nums = new int[size];
        for(int i=0; i<size; i++){
            int value = scan.nextInt();
            nums[i] = value;
        }
        int lenUsingRecursion = UsingRecursion(nums,Integer.MIN_VALUE, 0);
        System.out.println("Using recursion:- " + lenUsingRecursion);
        scan.close();
    }

    private static int UsingRecursion(int[] nums, int prev, int index) {
        // TODO Auto-generated method stub
        if(index == nums.length){
            return 0;
        }
        int exclude = UsingRecursion(nums,prev,index+1);
        int include = 0;
        if(nums[index]>prev){
            include = 1 + UsingRecursion(nums, nums[index], index+1);
        }
        return Math.max(exclude, include);
    }
}
