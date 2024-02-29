package Recursion;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        // Print the original stack
        System.out.println("Original Stack: " + stack);

        // Sort the stack
        sortStack(stack);
        
        // Print the sorted stack
        System.out.println("Sorted Stack: " + stack);
    }

    // Function to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int temp = stack.pop();

            // Recursively sort the remaining stack
            sortStack(stack);

            // Insert the popped element at its correct position
            insertAtCorrectPosition(stack, temp);
        }
    }

    // Function to insert an element at its correct position in a sorted stack
    public static void insertAtCorrectPosition(Stack<Integer> stack, int element) {
        // If the stack is empty or the current element is greater than the top of the stack
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } 
        else {
            // Pop elements greater than the current element
            int temp = stack.pop();
            // Recursively insert the element at its correct position
            insertAtCorrectPosition(stack, element);
            // Push back the popped element
            stack.push(temp);
        }
    }
}

