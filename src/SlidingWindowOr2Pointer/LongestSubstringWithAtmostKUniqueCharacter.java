package SlidingWindowOr2Pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithAtmostKUniqueCharacter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		int len = longestSubstrWithKUniqueAtmost(s,k);
		System.out.println("Longest length is:- " + len);
		scan.close();

	}

	private static int longestSubstrWithKUniqueAtmost(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int maxlength = 0;
		int l=0, r=0;
		int n = s.length();
		while(r<n) {
			char c = s.charAt(r);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if(map.size() > k) {
				int freq = map.get(s.charAt(l)) - 1;
				if(freq == 0) map.remove(s.charAt(l));
				l++;
			}
			if(map.size()<=k) maxlength = Math.max(maxlength, r-l+1);
			
			r++;
		}
		return maxlength;
	}

}
