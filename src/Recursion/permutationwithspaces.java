package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class permutationwithspaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String string;
		System.out.print("Enter the String:- ");
		string = scan.next();
		List<String> ans = new ArrayList<>();
		permutationforspaces(string, 0, "", ans);
		System.out.print(ans);
		scan.close();
	}

	private static void permutationforspaces(String string, int i, String string2, List<String> ans) {
		// TODO Auto-generated method stub
		if(i == string.length() - 1) {
			string2 += string.charAt(i);
			ans.add(string2);
			return;
		}
		else {
			string2 += string.charAt(i);
			permutationforspaces(string,i+1,string2,ans);
			string2 += '_';
			permutationforspaces(string,i+1,string2,ans);
		}
	}

}
