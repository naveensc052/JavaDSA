package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairSumTarget1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size: ");
		int size = scan.nextInt();
		int[] elements = new int[size];
		System.out.println("Enter elements: ");
		for(int i=0; i<size; i++) {
			int e = scan.nextInt();
			elements[i] = e;
		}
		System.out.println("Enter the target: ");
		int target = scan.nextInt();
		// Calling logic using Brute force;
		bruteforce(elements, target, size);
		// Algorithm by sorting
		sortingMethod(elements, target, size);
		// HaspMap Method
		hashmapMethod(elements, target, size);
		scan.close();
	}

	private static void bruteforce(int[] elements, int target, int size) {
		// TODO Auto-generated method stub
		System.out.println("Brute Force Method");
		
		for(int i=0; i<size; i++ ) {
			for(int j=i+1; j<size; j++) {
				if((elements[i] +  elements[j]) == target) {
					System.out.println("Pair = " + elements[i] + ", " + elements[j]);
					return;
				}
			}
		}
		System.out.println("Not Found");
	}

	private static void sortingMethod(int[] elements, int target, int size) {
		// TODO Auto-generated method stub
		System.out.println("Sorting Method");
		Arrays.sort(elements);
		int leftpointer = 0;
		int rightpointer = size-1;
		
		while(leftpointer<rightpointer) {
			int sum = elements[leftpointer] + elements[rightpointer];
			if(sum == target) {
				System.out.println("Pair = " + elements[leftpointer] + ", " + elements[rightpointer] );
				return;
			}
			else if(sum<target) {
				leftpointer++;
			}
			else {
				rightpointer--;
			}
		}
		System.out.println("Not Found");
		
	}
	
	private static void hashmapMethod(int[] elements, int target, int size) {
		// TODO Auto-generated method stub
		System.out.println("HaspMap Method");
		Map<Integer, Integer> map = new HashMap<>();
		for(int i =0; i<size; i++) {
			if(map.containsKey(target - elements[i])) {
				System.out.printf("Pair = %d, %d", elements[map.get(target - elements[i])], elements[i]);
				return;
			}
			map.put(elements[i], i);
		}
		System.out.println("Not Found");		
	}
}
