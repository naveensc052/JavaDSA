package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SortInOneSwap {

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
		sortArray(nums,size);
		System.out.println(Arrays.toString(nums));
	}

	private static void sortArray(int[] nums, int size) {
		// TODO Auto-generated method stub
		int x = -1, y = -1;
		int prev = nums[0];
		for(int i=1; i<size; i++) {
			if(prev > nums[i]) {
				if(x == -1) {
					x = i - 1;
                    y = i;
				}
				else {
					y = i;
				}
			}
			prev = nums[i];
		}
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
		System.out.println(Arrays.toString(nums));
	}

}
