package Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class findDuplicate5 {

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
		// Difference Sum Method
		System.out.println("Difference Sum Method:- ");
		differenceSumMethod(nums, size);
		// Using Hasing
		System.out.println("Hashing Method:- ");
		HashingMethod(nums,size);
		// Array Indice method
		System.out.println("Array Indice Method:- ");
		ArrayIndice(nums,size);
		System.out.println("XOR Method:- ");
		XOR(nums,size);
		scan.close();
	}

	private static void XOR(int[] nums, int size) {
		// TODO Auto-generated method stub
		int xor = 0;
		for(int value :nums) {
			xor = xor^value;
		}
		for(int i=1; i<size; i++) {
			xor = xor^i;
		}
		System.out.println("Duplicate Value is "+ xor);
	}

	private static void ArrayIndice(int[] nums, int size) {
		// TODO Auto-generated method stub
		for(int i=0; i<size; i++) {
			int index = Math.abs(nums[i])-1;
			if(nums[index]>0) {
				nums[index] = -nums[index];
			}
			else {
				System.out.println("Duplicate Element = " + nums[index+1]);
			}
		}
	}

	private static void HashingMethod(int[] nums, int size) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		for(int value: nums) {
			if(set.contains(value)) {
				System.out.println("Duplicate Element is " + value);
				return;
			}
			set.add(value);
		}
	}

	private static void differenceSumMethod(int[] nums, int size) {
		// TODO Auto-generated method stub
		int sum = size*(size+1)/2;
		for(int value:nums) {
			sum -= value;
		}
		System.out.printf("Duplicate Value = %d\n" , size-sum);
	}

}
