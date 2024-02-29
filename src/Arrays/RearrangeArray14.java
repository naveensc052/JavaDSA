package Arrays;
import java.util.Arrays;
/*
 * Rearrange the given Array So that the first element is small next is big and the next next is small then the 2nd element and so no
 */
import java.util.Scanner;

public class RearrangeArray14 {

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
		// Algorithm Function to call Rearrange Array
		System.out.println("Before:- " + Arrays.toString(nums));
		rearrange(nums,size);
		System.out.println("After:-  " + Arrays.toString(nums));
		scan.close();
	}

	private static void rearrange(int[] nums, int size) {
		// TODO Auto-generated method stub
		for(int i=1; i<size; i+=2) {
			if(nums[i]<nums[i-1]) {
				swap(nums, i,i-1);
			}
			if(i+1 < size && nums[i] < nums[i+1]) {
				swap(nums,i, i+1);
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
