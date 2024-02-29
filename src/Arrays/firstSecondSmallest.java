package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class firstSecondSmallest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        long[] nums = new long[size];
        for(int i=0; i<size; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(minAnd2ndMin(nums,size)));
        scan.close();
    }
    public static long[] minAnd2ndMin(long a[], long n)  
    {
        long small1 = Integer.MAX_VALUE;
        long small2 = Integer.MAX_VALUE;
        for(long i:a){
            if(i<small1){
                small2 = small1;
                small1 = i;
                
            }
            else if(i<small2 && i!=small1){
                small2 = i;
            }
        }
        if(small1 == Integer.MAX_VALUE){
            
            small1 = -1;
            return new long[]{small1};
        }
        if(small2 == Integer.MAX_VALUE){
            small2 = -1;
            return new long[]{small2};
        }
        return new long[]{small1,small2};
    }
}
