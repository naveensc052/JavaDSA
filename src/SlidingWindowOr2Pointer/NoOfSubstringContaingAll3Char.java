package SlidingWindowOr2Pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoOfSubstringContaingAll3Char {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int len = noOfSubWith3Char(s,3);
		System.out.println("Count of Substring is:- " + len);
		scan.close();
	}

	private static int noOfSubWith3Char(String s, int k) {
		int count = 0;
		int a = -1, b = -1, c = -1;
		int n = s.length();
		for(int i=0; i<n; i++) {
			char ch = s.charAt(i);
			if(ch == 'a') {
				a = i;
			}else if(ch == 'b') {
				b = i;
			}else {
				c = i;
			}
			if(a != -1 && b != -1 && c != -1) {
				int min = Math.min(a, Math.min(b, c));
				count += min+1;
			}
		}
		return  count;
	}

}
