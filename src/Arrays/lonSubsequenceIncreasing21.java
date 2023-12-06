package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lonSubsequenceIncreasing21 {

    public static List<Integer> findLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int[] tails = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int left = 0, right = len;

            while (left < right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = num;
            if (left == len) {
                len++;
            }
        }

        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            lis.add(tails[i]);
        }
        System.out.println(len);
        return lis;
    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size:- ");
		int size = scan.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter the elements:- ");
		for(int i=0; i<size; i++) {
			int value = scan.nextInt();
			nums[i] = value;
		}
        List<Integer> lis = findLIS(nums);

        System.out.println("Longest Increasing Subsequence: " + lis);
        System.out.println("Length of Longest Increasing Subsequence: " + lis.size());
        scan.close();
    }
}
