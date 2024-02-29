package Arrays;

import java.util.Scanner;

public class SecondHighestInArray {
    public static int findSecondHighest(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } 
            else if (num > secondMax && num != firstMax) {
                secondMax = num;
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        int secondHighest = findSecondHighest(arr);
        
        if (secondHighest != Integer.MIN_VALUE){
            System.out.println("Second highest number: " + secondHighest);
        } 
        else{
            System.out.println("No second highest number found.");
        }
        scanner.close();
    }
}

