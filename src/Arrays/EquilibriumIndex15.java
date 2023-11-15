package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EquilibriumIndex15 {

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
		// Algorithm Function for finding Equilibrium Index
		equilibriumpoint(nums,size);
		scan.close();
	}

	private static void equilibriumpoint(int[] nums, int size) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<size; i++) {
			right += nums[i];
		}
		if(right == 0) {
			list.add(0);
		}
		for(int i=1; i<size; i++) {
			right -= nums[i];
			left += nums[i-1];
			if(left == right) {
				list.add(i);
			}
		}
		System.out.println("Equilibrium Index are " + list);
	}

}
