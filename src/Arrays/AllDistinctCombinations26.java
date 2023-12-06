package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AllDistinctCombinations26 {

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
		System.out.println("Enter the len");
		int len = scan.nextInt();
		Set<List<Integer>> set = new HashSet<>();
		findAllCombinations(nums , 0, len, set, new ArrayList<>());
		System.out.print(set);
		scan.close();
	}

	private static void findAllCombinations(int[] nums, int i, int len, Set<List<Integer>> set, List<Integer> list) {
		// TODO Auto-generated method stub
		if(len == 0) {
			set.add(new ArrayList<>(list));
			return;
		}
		for(int j=i; j<nums.length; j++) {
			list.add(nums[j]);
			findAllCombinations(nums, j + 1, len - 1, set, list);
			list.remove(list.size()-1);
		}
	}

}
