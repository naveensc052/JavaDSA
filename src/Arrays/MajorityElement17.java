package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MajorityElement17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size:- ");
		int size = scan.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter the elements:- ");
		for(int i=0; i<size; i++) {
			int value = scan.nextInt();
			nums[i] = value;
		}
		// brute Force Method
		bruteForce(nums,size);
		// hashmap Method
		hashmapmethod(nums,size);
		// boyre More Voting Algorithm
		BoyreMoreAlgo(nums, size);
		scan.close();
	}

	private static void BoyreMoreAlgo(int[] nums, int size) {
		// TODO Auto-generated method stub
		int count = 0;
		int value = nums[0];
		for(int num: nums) {
			if(num == value) {
				count++;
			}
			else {
				count--;
				if(count == 0) {
					value = num;
					count++;
				}
			}
		}
		System.out.println("Solution Through HashMap Method is " + value);
	}

	private static void hashmapmethod(int[] nums, int size) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap<>();
		for(int num:nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > size/2) {
				System.out.println("Solution Through HashMap Method is " + entry.getKey());
				return;
			}
		}
	}

	private static void bruteForce(int[] nums, int size) {
		// TODO Auto-generated method stub
		for(int i=0; i<size; i++) {
			int count = 0;
			for(int j=0; j<size; j++) {
				if(i!=j && nums[i] == nums[j]) {
					count++;
				}
			}
			if(count >= size/2) {
				System.out.println("Solution Through Brute Force Method is " + nums[i]);
				return;
			}
		}
	}

}
