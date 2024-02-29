package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateallBalancedparenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size;
		System.out.print("Enter the Size:- ");
		size = scan.nextInt();
		List<String> ans = new ArrayList<>();
		solution(size, 0,0, "", ans);
		System.out.print(ans);
		scan.close();
	}

	private static void solution(int size, int left, int right, String string, List<String> ans) {
		// TODO Auto-generated method stub
		if(string.length() == size && left == right) {
			ans.add(string);
			return;
		}
		if(string.length() == size) {
			return;
		}
		else {
			if(left>=right) {
				solution(size,left+1,right,string+'(',ans);
				solution(size,left,right+1,string+')',ans);
			}
		}
	}

}
