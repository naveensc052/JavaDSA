package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class separateoddsevens {

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
        
        int i=-1;
        for(int j=0; j<n; j++) {
        	if(array[j]%2 == 1) {
        		i++;
        		int temp = array[j];
        		array[j] = array[i];
        		array[i] = temp;
        	}
        }
        System.out.println("Rearranged array: " + Arrays.toString(array));
        scan.close();
	}

}
