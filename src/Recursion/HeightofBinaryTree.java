package Recursion;

import java.util.Scanner;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class HeightofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Node root = null;
		System.out.println("Enter the value to the node and -1 to stop");
		int x;
		while(true) {
			System.out.print("Enter the value to the node and -1 to stop:- ");
			x = scan.nextInt();
			if(x==-1) {
				break;
			}
			root = addNode(root,x);
		}
		System.out.println("MaxHeight of the root is " + height(root));
	}
	public static Node addNode(Node root, int data) {
		if(root == null) {
			Node node = new Node(data);
			return node;
		}
		else {
			if(data < root.data) {
				root.left = addNode(root.left,data);
			}
			else {
				root.right = addNode(root.right,data);
			}
			return root;
		}
	}
	
	public static int height(Node root) {
		if(root == null) {
			return 0;
		}
		else {
			int left = height(root.left);
			int right = height(root.right);
			return Math.max(left, right) + 1;
		}
	}
}
