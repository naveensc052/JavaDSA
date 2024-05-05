package Arrays;

import java.util.Arrays;

public class ArrayReduction {

    public static double totalCost(int[] arr) {
        int n = arr.length;
        double totalCost = 0;
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[n-1];
        for(int i=0; i<n-1; i++) {
        	min = arr[i];
        	totalCost += (max+min)/(max-min+1);
        	max = min + max;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7}; // Example array
        double cost = totalCost(arr);
        System.out.println("Total cost to reduce the array: " + cost);
    }
}

