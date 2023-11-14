package Arrays;

import java.util.HashMap;
import java.util.Scanner;

public class MaxlenofSubarraywithtarget6 {

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
		System.out.println("Eneter the target: ");
		int target = scan.nextInt();
		
		// Brute force Method
		bruteforce(nums,size, target);
		// HaspMap Method
		HashmapMethod(nums,size, target);
		scan.close();
	}

	private static void bruteforce(int[] nums, int size, int target) {
		// TODO Auto-generated method stub
		int max = 0;
		int startindex = -1;
		int endindex = -1;
		for(int i=0; i<size; i++) {
			int current = 0;
			for(int j=i; j<size; j++) {
				current += nums[j];
				if(current == target && max < j-i+1) {
					max = j-i+1;
					startindex = i;
					endindex = j;
				}
			}
		}
		System.out.println("MaxLength = " + max + "\nSubarray is nums[" + startindex + "...." + endindex + "]");
		
	}

	private static void HashmapMethod(int[] nums, int size, int target) {
		// TODO Auto-generated method stub
		int current = 0;
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int startindex = -1;
		int endindex = -1;
		hashmap.put(0, -1);
		int max = -1;
		for(int i=0; i<size; i++) {
			current += nums[i];
			hashmap.putIfAbsent(current, i);
			if(hashmap.containsKey(current - target) && max < i-hashmap.get(current - target)) {
				startindex = hashmap.get(current-target) + 1;
				endindex = i;
				max = i-hashmap.get(current - target);
			}
		}
		System.out.println("MaxLength = " + max + "\nSubarray is nums[" + startindex + "...." + endindex + "]");
		
	}

}
