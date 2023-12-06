package Arrays;
/*
 * find special array element such that all the elements left to is are smaller
 */
import java.util.Scanner;

public class findSpecialElement {
	    public static void main(String[] args) {
	    	Scanner scan = new Scanner(System.in);
			System.out.print("Enter the Size:- ");
			int size = scan.nextInt();
			int[] nums = new int[size];
			System.out.println("Enter the elements:- ");
			for(int i=0; i<size; i++) {
				int value = scan.nextInt();
				nums[i] = value;
			}
	        int result = findElement(nums);
	        
	        if (result != -1) {
	            System.out.println("Element found: " + nums[result]);
	        } else {
	            System.out.println("No such element found");
	        }
	        scan.close();
	    }

	    static int findElement(int[] arr) {
	        int n = arr.length;

	        // Initialize two arrays to store the maximum element on the left and minimum element on the right
	        int[] leftMax = new int[n];
	        int[] rightMin = new int[n];

	        // Fill leftMax array
	        leftMax[0] = arr[0];
	        for (int i = 1; i < n; i++) {
	            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
	        }

	        // Fill rightMin array
	        rightMin[n - 1] = arr[n - 1];
	        for (int i = n - 2; i >= 0; i--) {
	            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
	        }

	        // Find the element that satisfies the condition
	        for (int i = 1; i < n - 1; i++) {
	            if (arr[i] >= leftMax[i - 1] && arr[i] <= rightMin[i + 1]) {
	                return i;
	            }
	        }

	        // If no such element is found
	        return -1;
	    }
	}

