package Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubarraySumzero2 {

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
		if(hasSubarraySumZero(elements,size)) {
			System.out.println("Subarray Exists");
		}
		else {
			System.out.println("Subarray Does not Exists");
		}
		scan.close();
	}

	private static boolean hasSubarraySumZero(int[] elements, int size) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		int sum=0;
		set.add(0);
		for(int value:elements) {
			sum += value;
			if(set.contains(sum)) {
				return true;
			}
			set.add(sum);
		}
		return false;
	}

}
