package LinkedList;

import java.util.Scanner;

public class InsertionatTail {
	public static class Node{
		int data;
		Node next;
		
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	// Creation of Node
	public static Node newNode(int key) {
		Node node = new Node(key,null);
		return node;
	}
	
	public static Node insert(Node head, int key) {
		Node cur = head;
		Node node = newNode(key);
		if(cur == null) {
			return node;
		}
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
		return head;
	}
	
	// Printing the Linked List
	public static void printList(Node head) {
		if(head == null) {
			return;
		}
		Node cur = head;
		System.out.print("Data in the linked List is:- ");
		while(cur != null) {
			System.out.print(cur.data + "  ");
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int key;
		Node head = null;
		while(true) {
			System.out.print("Enter the key for list else enter -1:- ");
			key = scan.nextInt();
			if(key == -1) {
				break;
			}
			head = insert(head,key);
		}
		printList(head);
		scan.close();
	}

}
