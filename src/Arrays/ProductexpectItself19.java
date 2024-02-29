package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ProductexpectItself19 {

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
		//Using Recursion
		System.out.println("Before : " +"nums = " + Arrays.toString(nums));
		recursion(nums,size,1,0);
		System.out.println("After : " +"nums = " + Arrays.toString(nums));
		scan.close();
	}

	private static int recursion(int[] nums, int size, int left, int i) {
		// TODO Auto-generated method stub
		if(i == size) {
			return 1;
		}
		int cur = nums[i];
		int right = recursion(nums,size,cur*left,i+1);
		nums[i] = left*right;
		return cur*right;
	}

}
