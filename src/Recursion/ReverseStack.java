package Recursion;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter the element to push to stack else enter -1:- ");
			int x = scan.nextInt();
			if(x == -1) {
				break;
			}
			stack.push(x);
		}
		
		System.out.println("Before:- " + stack);
		Reverse(stack);
		System.out.println("After:- " + stack);
		scan.close();
	}

	private static void Reverse(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(stack.size() == 0) {
			return;
		}
		else {
			int temp = stack.pop();
			Reverse(stack);
			insertBottom(stack,temp);
		}
	}

	private static void insertBottom(Stack<Integer> stack, int element) {
		// TODO Auto-generated method stub
		if(stack.size() == 0) {
			stack.push(element);
			return;
		}
		else {
			int temp = stack.pop();
			insertBottom(stack,element);
			stack.push(temp);
		}
	}

}
