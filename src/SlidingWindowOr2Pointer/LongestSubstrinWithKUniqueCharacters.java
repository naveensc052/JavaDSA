package SlidingWindowOr2Pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstrinWithKUniqueCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		int len = longestkSubstr(s,k);
		System.out.println("Longest length is:- " + len);
		scan.close();
	}

	private static int longestkSubstr(String s, int k) {
		int ans = 0;
        char[] fruits = s.toCharArray();
        int n = fruits.length;
        int l = 0, r =0;
        Map<Character, Integer> map = new HashMap<>();
        while(r<n){
            char fruit = fruits[r];
            map.put(fruit, map.getOrDefault(fruit,0)+1);
            if(map.size()>k){
                int freq = map.get(fruits[l]);
                map.put(fruits[l], map.getOrDefault(fruits[l],0) - 1);
                if(freq == 1){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size()==k)
                ans = Math.max(ans, r-l+1);
            r = r+1;
        }
        
        return ans>0?ans:-1;
	}

}
