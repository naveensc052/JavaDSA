package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Binarysort4 {

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
		// Simple Method by calculating number of zero
		System.out.println("Simple Method:- ");
		simplemethod(elements,size);
		
		// Quick partition method
		System.out.println("Quick Partition Method:- ");
		quickpartitionmethod(elements,size);
		scan.close();
	}

	private static void simplemethod(int[] elements, int size) {
		// TODO Auto-generated method stub
		int nonzero = 0;
		for(int i: elements) {
			if(i == 0) {
				elements[nonzero] = 0;
				System.out.print(elements[nonzero] + "  ");
				nonzero++;
			}
		}
		for(int i=nonzero; i<size; i++) {
			elements[i] = 1;
			System.out.print(elements[i] + "  ");
		}
		System.out.println();
	}

	private static void quickpartitionmethod(int[] elements, int size) {
		// TODO Auto-generated method stub
		int nonzeroelement = 0;
		for(int i=0; i<size; i++) {
			if(elements[i] == 0) {
				int temp = elements[i];
				elements[i] = elements[nonzeroelement];
				elements[nonzeroelement] = temp;
				nonzeroelement++;
			}
		}
		System.out.println(Arrays.toString(elements));
	}

}
