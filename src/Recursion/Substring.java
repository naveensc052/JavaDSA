package Recursion;

import java.util.*;

public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String");
		String A = scan.next();
		System.out.println(A);
		List<String> ans = new ArrayList<>();
		ans = AllSubStringRecursion(A);
		System.out.println(ans);
		scan.close();
	}
	
	public static List<String> AllSubStringRecursion(String A){
		List<String> ans = new ArrayList<>();
		generateSubstrings(A, 0, "", ans);
        return ans;
		
	}
	private static void generateSubstrings(String input, int index, String current, List<String> ans){
        if (index == input.length()){
            ans.add(current);
            return;
        }
        generateSubstrings(input, index + 1, current + input.charAt(index), ans);
        generateSubstrings(input, index + 1, current, ans);
    }

}
