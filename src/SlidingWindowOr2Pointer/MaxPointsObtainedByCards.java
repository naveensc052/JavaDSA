package SlidingWindowOr2Pointer;

import java.util.Scanner;

// Leetcode question:- https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class MaxPointsObtainedByCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		int k = scan.nextInt();
		int ans = solution(arr, n, k);
		System.out.println("Maximum Obtained values is:- " + ans);
		scan.close();
	}

	private static int solution(int[] cardPoints, int n, int k) {
		int l = 0, r = cardPoints.length-1;
        int maxsum = 0;
        for(int i=0; i<k; i++){
            maxsum+=cardPoints[i];
        }
        int sum = maxsum;
        l = k-1;
        while(l>=0){
            int cur = sum - cardPoints[l] + cardPoints[r];
            maxsum = Math.max(maxsum,cur);
            sum = cur;
            l--;
            r--;
        }
        return maxsum;
	}

}
