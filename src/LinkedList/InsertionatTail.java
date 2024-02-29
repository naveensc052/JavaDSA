package LinkedList;

import java.util.Scanner;

public class InsertionatTail {
	public static Node insert(Node head, int key) {
		Node cur = head;
		Node node = new Node(key);
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
		Scanner scan = new Scanner(System.in);
		int key;
		/* 
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
		*/
		Node start = null;
		Node mover = start;
		while(true) {
			System.out.print("Enter the key for list else enter -1:- ");
			key = scan.nextInt();
			if(key == -1) {
				break;
			}
			Node nod = new Node(key, null);
			mover = insertUsingMover(nod, start, mover);
			if (start == null) {
				start = nod;
			}
		}
		printList(start);
		scan.close();
	}
	
	// Optimal way to insert  into Linked List
	public static Node insertUsingMover(Node node, Node start, Node mover){
		if(start == null){
			start = node;
			mover = start;
		}else{
			mover.next = node;
			mover = node;
		}
		return mover;
	}
}
