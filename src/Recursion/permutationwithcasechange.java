package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class permutationwithcasechange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String string;
		System.out.print("Enter the String:- ");
		string = scan.next();
		List<String> ans = new ArrayList<>();
		permutationforcasechange(string, 0, "", ans);
		System.out.print(ans);
		scan.close();
	}

	private static void permutationforcasechange(String string, int i, String string2, List<String> ans) {
		// TODO Auto-generated method stub
		if(i == string.length()) {
			ans.add(string2);
			return;
		}
		else {
			permutationforcasechange(string, i+1, string2 + string.charAt(i), ans);
			int value = string.charAt(i) - 'a';
			char c = (char)('A' + value);
			permutationforcasechange(string, i+1, string2 + c, ans);
		}
	}

}
