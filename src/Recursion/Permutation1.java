package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutation1 {

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
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
	}

}
