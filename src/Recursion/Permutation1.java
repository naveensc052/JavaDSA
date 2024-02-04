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
		boolean[] visited = new boolean[size];
		System.out.println("Enter elements: ");
		for(int i=0; i<size; i++) {
			int e = scan.nextInt();
			nums[i] = e;
		}
		List<List<Integer>> result = new ArrayList<>();
		permute(nums, visited, new ArrayList<>(), result );
		System.out.println(result);
		scan.close();
	}

	private static void permute(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
		// TODO Auto-generated method stub
		if(list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		else {
			for(int i=0; i<nums.length; i++) {
				if(!visited[i]) {
					list.add(nums[i]);
					visited[i] = true;
					permute(nums,visited, list,result);
					visited[i] = false;
					list.remove(list.size()-1);
				}
			}
		}
	}

}
