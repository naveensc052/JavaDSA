package Arrays;
import java.util.*;

public class ReplaceZerotoOneforMaxlenofOnes12 {

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
		
		// Brute Force Method
		System.out.println("Brute Force Method:- ");
		bruteforce(nums,size);
		// Previous Index Method
		System.out.println("Previous Index Method:- ");
		previousindexmethod(nums,size);
		scan.close();
	}

	private static void previousindexmethod(int[] nums, int size) {
		// TODO Auto-generated method stub
		int maxlen = 0;
		int prevzeroindex = -1;
		int count = 0;
		int zeroindex = -1;
		for(int i=0; i<size; i++) {
			if(nums[i] == 1) {
				count++;
			}
			else {
				count = i - prevzeroindex;
				prevzeroindex = i;
			}
			if(count>maxlen) {
				maxlen = count;
				zeroindex = prevzeroindex;
			}
		}
		System.out.println("MaxLength = " + maxlen + "\nIndex = " + zeroindex);
	}

	private static void bruteforce(int[] nums, int size) {
		// TODO Auto-generated method stub
		int maxlen = 0, index = -1;
		for(int i=0; i<size; i++) {
			int flag = 0;
			if(nums[i] == 0) {
				nums[i] = 1;
				flag = 1;
			}
			int count = 0;
			for(int j=0; j<size; j++) {
				if(nums[j] == 1) {
					count++;
				}
				else {
					count = 0;
				}
				if(maxlen < count) {
					maxlen = count;
					index = i;
				}
			}
			if(flag == 1) {
				nums[i] = 0;
			}
		}
		System.out.println("MaxLength = " + maxlen + "\nIndex = " + index);
	}

}
