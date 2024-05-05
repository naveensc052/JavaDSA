package SlidingWindowOr2Pointer;

import java.util.Scanner;

// Leetcode question:- https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubStringWithoutRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int len = lengthOfLongestSubstring(s);
		System.out.println("Longest length is:- " + len);
		scan.close();
	}

	private static int lengthOfLongestSubstring(String s) {
        int[] val = new int[256];
        int l=0, r=0;
        int len = 0;
        int n = s.length();
        while(r<n){
            if(val[s.charAt(r)] == 0){
                
                val[s.charAt(r)] = 1;
                r++;
                len = Math.max(len, r-l);
            }else{
                val[s.charAt(l)] = 0;
                l++;
            }
        }
        return len;
	}

}
