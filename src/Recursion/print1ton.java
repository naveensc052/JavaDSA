package Recursion;

import java.util.Scanner;

public class print1ton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number:- ");
		int n = scan.nextInt();
		recursion(n);
		scan.close();
	}

	private static void recursion(int n) {
		// TODO Auto-generated method stub
		if(n == 0) {
			return;
		}
		recursion(n-1);
		System.out.print(n + " ");
	}

}
