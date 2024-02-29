package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LonConSeqwithSameSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size:- ");
		int size = scan.nextInt();
		int[] nums1 = new int[size];
		System.out.println("Enter the elements2:- ");
		for(int i=0; i<size; i++) {
			int value = scan.nextInt();
			nums1[i] = value;
		}
		int[] nums2 = new int[size];
		System.out.println("Enter the elements2:- ");
		for(int i=0; i<size; i++) {
			int value = scan.nextInt();
			nums2[i] = value;
		}
		System.out.println(longestContinuousbinarylengthwithSameSum(nums1,nums2,size));
		scan.close();
	}

	private static int longestContinuousbinarylengthwithSameSum(int[] nums1, int[] nums2, int size) {
		// TODO Auto-generated method stub
		int result = 0;
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		int x = 0, y = 0;
		for(int i = 0; i<size; i++) {
			x += nums1[i];
			y += nums2[i];
			int dif = x - y;
			if(!map.containsKey(dif)) {
				map.put(dif, i);
			}else {
				result = Math.max(result,i - map.get(dif));
			}
		}
		return result;
	}
}
