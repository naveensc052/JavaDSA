package LinkedList;
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    void insertNode(int val){
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    Node reverse(Node par) {
        Node prev = null;
        Node current = par;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    void rearrange() {
        if (head == null || head.next == null || head.next.next == null){
            System.out.println("Cannot Do");
            return;
        } else {
            Node slow = head;
            Node fast = head;
            Node prevSlow = null;
            while (fast != null && fast.next != null){
                prevSlow = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse the second half of the linked list
            Node secondHalf = slow;
            prevSlow.next = null;
            Node reversedSecondHalf = reverse(secondHalf);

            // Merge the two halves
            Node current1 = head;
            Node current2 = reversedSecondHalf;

            while (current2 != null) {
                Node next1 = current1.next;
                Node next2 = current2.next;
                current1.next = current2;
                current2.next = next1;
                current1 = next1;
                current2 = next2;
            }
        }
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}

public class LinkedListRerrange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the n value: ");
        int n = scanner.nextInt();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value: ");
            int val = scanner.nextInt();
            linkedList.insertNode(val);
        }
        scanner.close();
        linkedList.printList();
        linkedList.rearrange();
        linkedList.printList();
    }
}
