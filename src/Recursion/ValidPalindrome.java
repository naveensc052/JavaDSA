package Recursion;

import java.util.Scanner;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String");
		String A = scan.next();
		System.out.println(A);
		if(isvalid(A)) {
			System.out.println("Valid Palindrome");
		}
		else {
			System.out.println("Not a Valid Palindrome");
		}
		scan.close();
	}

	private static boolean isvalid(String a) {
		// TODO Auto-generated method stub
		int j = a.length()-1;
		if(j <= 1) {
			return true;
		}
		if(a.charAt(0) != a.charAt(a.length()-1)){
			return false;
		}
		
		return isvalid(a.substring(1, j));
	}

}
