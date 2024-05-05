package Stack;

import java.util.Scanner;
import java.util.Stack;

public class SubstringRemoval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int len = find_min_len(str);
		System.out.print(len);
		scan.close();
	}

	private static int find_min_len(String str) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<>();
		for(char c :str.toCharArray()) {
			if(c == 'A') {
				stack.add(c);
			}else {
				if(stack.isEmpty()) {
					stack.add(c);
				}else {
					stack.pop();
				}
			}
		}
		return stack.size();
	}

}
