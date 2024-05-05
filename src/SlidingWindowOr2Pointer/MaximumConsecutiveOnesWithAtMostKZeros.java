package SlidingWindowOr2Pointer;

import java.util.Scanner;

public class MaximumConsecutiveOnesWithAtMostKZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = scan.nextInt();
		}
		int k = scan.nextInt();
		int len = longestOnes(nums,k);
		System.out.println("Maximum length is:- " + len);
		scan.close();
	}

//	private static int longestOnes(int[] nums, int k) {
//        int count_zero = 0;
//        int l=0, r = 0;
//        int n = nums.length;
//        int maxlen = 0;
//        while(r<n){
//            if(nums[r] == 1){
//                maxlen = Math.max(maxlen, r-l+1);
//                r++;
//            }else{
//                if(count_zero<k){
//                    count_zero += 1;
//                    maxlen = Math.max(maxlen, r-l+1);
//                    r++;
//                }
//                else{
//                    if(nums[l] == 0){
//                        count_zero -= 1;
//                    }
//                    l++;
//                }
//            }
//        }
//        return maxlen;
//	}
	private static int longestOnes(int[] nums, int k) {
        int count_zero = 0;
        int l=0, r = 0;
        int n = nums.length;
        int maxlen = 0;
        while(r<n){
            if(nums[r] == 0) count_zero++;
            
            if(count_zero>k) {
            	if(nums[l] == 0) count_zero--;
            	l++;
            }
            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }
        return maxlen;
	}
}
