package Recursion;
import java.util.Scanner;
import java.util.Arrays;

public class SortusingRecursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Size:- ");
        int size = scan.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements:- ");
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            nums[i] = value;
        }
        sortusingRecursion(nums, size, 0);
        
        System.out.println("Sorted Array: " + Arrays.toString(nums));
    }

    private static void sortusingRecursion(int[] nums, int size, int index) {
        if (size - 1 == index) {
            return;
        } 
        else {
            sortusingRecursion(nums, size, index + 1);
            int key = nums[index];
            int i = index + 1;
            while (i < size && nums[i] < key) {
                nums[i - 1] = nums[i];
                i++;
            }
            nums[i - 1] = key;
        }
    }
}
