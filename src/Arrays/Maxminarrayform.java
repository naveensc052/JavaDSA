package Arrays;

import java.util.*;

public class Maxminarrayform {

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
        Arrays.sort(array);
        int left = 0;
        int right = n - 1;
        int i = 0;
        int[] rearrangedArray = new int[n];
        while (left <= right) {
            rearrangedArray[i] = array[right--];
            if (i + 1 < n) { 
                rearrangedArray[i + 1] = array[left++];
            }
            i += 2;
        }
        System.out.println("Rearranged array: " + Arrays.toString(rearrangedArray));
        scan.close();
    }
}
