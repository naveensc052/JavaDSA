package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Wavesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter the size of the array: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        
        for(int i=1; i<n-1; i=i+2) {
        	if(array[i]>array[i-1]) {
        		int temp = array[i];
        		array[i] = array[i-1];
        		array[i-1] = temp;
        	}
        	if(array[i+1]<array[i]) {
        		int temp = array[i];
        		array[i] = array[i+1];
        		array[i+1] = temp;
        	}
        	System.out.println(Arrays.toString(array));
        }
        if(n%2 == 0 && array[n-1]> array[n-2]) {
        	int temp = array[n-1];
    		array[n-1] = array[n-2];
    		array[n-2] = temp;
        }
        System.out.println("Rearranged array: " + Arrays.toString(array));
        scan.close();
	}

}
