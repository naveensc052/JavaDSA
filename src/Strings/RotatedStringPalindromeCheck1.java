package Strings;

import java.util.Scanner;

public class RotatedStringPalindromeCheck1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the String: - ");
		String str = scan.next();
		// Function to check whether rotated String palindrome or not
		rotateStringCheck(str);
		scan.close();
	}

	private static void rotateStringCheck(String str) {
		int len = str.length();
		for(int i=0; i<len; i++) {
			if(ispalindrome(str.substring(i, len) + str.substring(0, i), len)) {
				System.out.println("Given String can be made palindrome and the palindrome string is: '" + str.substring(i, len) + str.substring(0, i) + "'");
				return;
			}
		}
		System.out.println("No palindrome formed");
	}

	private static boolean ispalindrome(String string, int len) {
		int start = 0, end = len -1;
		while(start<end) {
			if(string.charAt(start) != string.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
/* 
	private static void rotateStringCheck2(String str) {
		int len = str.length();
		for(int i=0; i<len; i++) {
			str = str.substring(1) + str.charAt(0);
			if(ispalindrome(str, len)) {
				System.out.println("Given String can be made palindrome and the palindrome string is: '" + str.substring(i, len) + str.substring(0, i) + "'");
				return;
			}
		}
		System.out.println("No palindrome formed");
	}

*/
}
