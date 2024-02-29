package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nbitmorezero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N;
		System.out.print("Enter the Size:- ");
		N = scan.nextInt();
		List<String> ans = new ArrayList<>();
		solution(N, 0,0, "", ans);
		System.out.print(ans);
		scan.close();
	}

	private static void solution(int N, int one, int zero, String string, List<String> ans) {
		// TODO Auto-generated method stub
		if(string.length() == N && one>=zero) {
			ans.add(string);
			return;
		}
		if(N == string.length()) {
			return;
		}
		else {
			solution(N,one+1,zero,string + '1', ans);
			solution(N,one,zero+1,string + '0',ans);
		}
	}

}
