package Arrays;

import java.util.*;

public class Rerrangetoallevengreater {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter the size of the array: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		System.out.println("Enter the elements of the array");
		for(int i=0; i<n; i++) {
			array[i] = scan.nextInt();
		}
		
		System.out.println("Array elements are: "+ Arrays.toString(array));
		int[] rearrangedArray = new int[n];

        int evenIndex = 0;
        int oddIndex = n / 2;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rearrangedArray[i] = array[evenIndex++];
            } else {
                rearrangedArray[i] = array[oddIndex++];
            }
        }
        System.out.println("Rearranged array to make even indices greater: " + Arrays.toString(rearrangedArray));
        scan.close();
	}

}
