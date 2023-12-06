package Recursion;

import java.util.Scanner;
import java.util.Stack;

public class DeleteMiddleElement {

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
		DeleteusingRecursion(stack,stack.size()/2 + 1);
		System.out.println("After:- " + stack);
	}

	private static void DeleteusingRecursion(Stack<Integer> stack, int size) {
		// TODO Auto-generated method stub
		if(size == 1) {
			stack.pop();
			return;
		}
		else {
			int temp = stack.pop();
			DeleteusingRecursion(stack,size-1);
			stack.push(temp);
		}
	}
}
