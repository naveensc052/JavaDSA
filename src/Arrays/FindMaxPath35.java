package Arrays;

import java.util.Scanner;

public class FindMaxPath35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size1: ");
		int size1 = scan.nextInt();
		int[] nums1 = new int[size1];
		System.out.println("Enter elements1: ");
		for(int i=0; i<size1; i++) {
			int e = scan.nextInt();
			nums1[i] = e;
		}
		System.out.print("Enter the Size2: ");
		int size2 = scan.nextInt();
		int[] nums2 = new int[size2];
		System.out.println("Enter elements2: ");
		for(int i=0; i<size2; i++) {
			int e = scan.nextInt();
			nums2[i] = e;
		}
		System.out.print("Max Sum Path is " + maxSum(nums1,nums2));
		scan.close();
	}
	public static int maxSum(int[] nums1, int[] nums2) {
        int sum = 0;
        int xsum = 0;
        int ysum = 0;
        int x = nums1.length;
        int y = nums2.length;
        int i = 0;
        int j = 0;
        while(i<x && j<y){
            while(i<x-1 && nums1[i] == nums1[i+1]){
                xsum += nums1[i];
                i++;
            }
            while(j<y-1 && nums2[j] == nums2[j+1]){
                ysum += nums2[j];
                j++;
            }
            if(nums1[i]<nums2[j]){
                xsum += nums1[i];
                i++;
            }
            else if(nums1[i]>nums2[j]){
                ysum += nums2[j];
                j++;
            }
            else{
                sum += Math.max(xsum,ysum) + nums1[i];
                xsum = 0;
                ysum = 0; 
                i++;
                j++;
            }
        }
        while(i<x){
            xsum += nums1[i++];
        }
        while(j<y){
            ysum += nums2[j++];
        }
        sum += Math.max(xsum,ysum);
        return sum;
    }
	
	public static int maxSum1(int[] nums1, int[] nums2) {
        int MOD = 1000000007;
        
        int m = nums1.length;
        int n = nums2.length;

        long sum1 = 0, sum2 = 0;
        int i = 0, j = 0;

        long result = 0;

        while (i < m || j < n) {
            if (i < m && (j == n || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (j < n && (i == m || nums1[i] > nums2[j])) {
                sum2 += nums2[j++];
            } else {
                result += Math.max(sum1, sum2) + nums1[i];
                sum1 = sum2 = 0;
                i++;
                j++;
            }
        }

        result += Math.max(sum1, sum2);
        return (int) (result % MOD);
    }
}
