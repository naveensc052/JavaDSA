package Arrays;

import java.util.Scanner;

public class MoveZerotoBegining {
	public static void movezeros(int[] array) {
		int n = array.length;
		int nonzeroindex = n-1;
		for(int i=n-1; i>=0; i--) {
			if(array[i] != 0) {
				array[nonzeroindex] = array[i];
				nonzeroindex--;
			}
		}
		for(int i=0; i<nonzeroindex; i++) {
			array[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
        int size = scan.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
		System.out.println("elements of the array:");
		for(int num : array) {
			System.out.println(num + " ");
		}
		movezeros(array);
		System.out.println("elements of the array after moving Zero to end:");
		for(int num : array) {
			System.out.println(num + " ");
		}
		scan.close();
	}
}
