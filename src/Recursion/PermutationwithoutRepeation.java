package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PermutationwithoutRepeation {

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
				boolean[] visited = new boolean[size];
				Arrays.sort(nums);
				solution(nums,size, visited, list, result);
				System.out.println(result);
				scan.close();
			}

			private static void solution(int[] nums, int size, boolean[] visited, List<Integer> list,
					List<List<Integer>> result) {
				// TODO Auto-generated method stub
				if(list.size() == nums.length) {
					result.add(new ArrayList<>(list));
					return;
				}
				for(int i = 0; i<size; i++){
					if(visited[i] || (i>0 && nums[i] == nums[i-1] && !visited[i-1])) {
						continue;
					}
					visited[i] = true;
					list.add(nums[i]);
					solution(nums,size,visited,list,result);
					visited[i] = false;
					list.remove(list.size() - 1);
				}
			}
}
