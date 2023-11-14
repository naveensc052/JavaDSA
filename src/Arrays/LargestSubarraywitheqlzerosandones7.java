package Arrays;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubarraywitheqlzerosandones7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size: ");
		int size = scan.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter elements: ");
		for(int i=0; i<size; i++) {
			int e = scan.nextInt();
			nums[i] = e;
		}
		//Brute force (zero pointer one pointer when equal find length)
		System.out.println("Brute Force Method:- ");
		bruteforce(nums,size);
		//HashMap Method
		System.out.println("HashMap Force Method:- ");
		hashmapmethod(nums, size);
		scan.close();
	}

	private static void hashmapmethod(int[] nums, int size) {
		// TODO Auto-generated method stub
		int sum = 0;
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int len = 0;
		int endindex = -1;
		int startindex = -1;
		hashmap.put(0, -1);
		for(int i=0; i<size; i++ ) {
			int value = nums[i];
			sum += (value == 0)?-1:1;
			if(hashmap.containsKey(sum)) {
				if(len < i - hashmap.get(sum) ) {
					len = i - hashmap.get(sum);
					endindex = len;
					startindex = hashmap.get(sum) + 1;
				}
			}
			else {
				hashmap.put(sum, i);
			}
		}
		System.out.println("MaxLength = " + len + "\nSubarray is nums[" + startindex + "...." + endindex + "]");
	}

	private static void bruteforce(int[] nums, int size) {
	    int maxLength = 0;
	    int startindex = -1;
	    int endindex = -1;
	    for (int i = 0; i < size; i++) {
	        int zeros = 0;
	        int ones = 0;
	        for (int j = i; j < size; j++) {
	            if (nums[j] == 0) {
	                zeros++;
	            } 
	            else {
	                ones++;
	            }
	            if (zeros == ones && j - i + 1 > maxLength) {
	                maxLength = j - i + 1;
	                startindex = i;
	                endindex = j;
	            }
	        }
	    }

	    if (maxLength > 0) {
	        System.out.println("MaxLength = " + maxLength + "\nSubarray is nums[" + startindex + "...." + endindex + "]");
	    } 
	    else {
	        System.out.println("No subarray found with equal number of zeros and ones.");
	    }
	}


}
