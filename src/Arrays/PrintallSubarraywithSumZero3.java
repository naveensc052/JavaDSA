package Arrays;

import java.util.Scanner;

public class PrintallSubarraywithSumZero3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size: ");
		int size = scan.nextInt();
		int[] elements = new int[size];
		System.out.println("Enter elements: ");
		for(int i=0; i<size; i++) {
			int e = scan.nextInt();
			elements[i] = e;
		}
		//brute force method
		bruteforce(elements, size);
		//hashmap method
		Hashmap(elements,size);
		scan.close();
	}

	private static void bruteforce(int[] elements, int size) {
		// TODO Auto-generated method stub
		for(int i=0; i<size; i++) {
			int sum = 0;
			for(int j=i; j<size; j++) {
				sum += elements[j];
				if(sum == 0) {
					System.out.println("elements["+ i + "...." + j + "]");
				}
			}
		}
	}
	
	private static void Hashmap(int[] elements, int size) {
		// TODO Auto-generated method stub
		
	}

}