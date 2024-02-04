package LinkedList;

import java.util.Scanner;

public class ReverseSingleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Node head = null;
		int data;
		while(true) {
			System.out.println("Enter data to linked list or -1 to stop:- ");
			data = scan.nextInt();
			if(data == -1) {
				break;
			}
			Node node = new Node(data);
			head = inserttoHead(head,node);
		}
		System.out.println("Before:- ");
		print(head);
		System.out.println("After:- ");
		head = reverseListRecursion(head);
		head = reverselist(head);
		print(head);
		scan.close();
	}

	private static Node reverseListRecursion(Node head) {
		// TODO Auto-generated method stub
		if(head == null || head.next == null) {
			return head;
		}
		else {
			Node next = head.next;
			head.next = null;
			Node reversed = reverseListRecursion(next);
			next.next = head;
			return reversed;
		}
	}

	private static void print(Node head) {
		// TODO Auto-generated method stub
		Node cur = head;
		while(cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
	}

	private static Node reverselist(Node head) {
	    if (head == null || head.next == null) {
	        return head;
	    } 
	    else {
	        Node prev = null;
	        Node cur = head;
	        Node next = null;
	        while (cur != null) {
	            next = cur.next;
	            cur.next = prev;
	            prev = cur;
	            cur = next;
	        }
	        head = prev;
	    }
	    // Print the reversed list after updating head
	    print(head);
	    return head;
	}


	private static Node inserttoHead(Node head, Node node) {
		// TODO Auto-generated method stub
		if(head == null) {
			return node;
		}
		else {
			Node cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = node;
			return head;
		}
	}
}