package LinkedList;

import java.util.Scanner;

public class SortLinkedList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node head = null;
        Node mover = null;
        while (true) {
            int val = scan.nextInt();
            if(val>9999){
                break;
            }
            if(head == null){
                Node node = new Node(val, null);
                head = node;
                mover = head;
            }else{
                mover.next = new Node(val, null);
                mover = mover.next;
            }
        }
        System.out.println("Before:- ");
        printLL(head);
        head = sortLL(head);
        System.out.println("After:- ");
        printLL(head);
        scan.close();
    }

    private static Node sortLL(Node head) {
        if(head == null || head.next == null){
            return head;
        }else{
            Node result = null;
            Node cur = head;
            Node next;
            while(cur != null){
                next = cur.next;
                result = sorting(result, cur);
                cur = next;
            }
            return result;
        }
    }

    private static Node sorting(Node head, Node newNode) {
        Node dummy = new Node();
        Node current = dummy;
        dummy.next = head;
 
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }
 
        newNode.next = current.next;
        current.next = newNode;
        return dummy.next;
        // if(head == null){
        //     return new Node(newNode.data, null);
        // }else if(head.data > newNode.data){
        //     Node node = new Node(newNode.data, head);
        //     return node;
        // }else{
        //     Node cur = head;
        //     Node prev = null; 
        //     while(cur != null &&  cur.data > newNode.data){
        //         prev = cur;
        //         cur = cur.next;
        //     }
        //     if(cur == null){
        //         prev.next = new Node(newNode.data, null);
        //     }else{
        //         prev.next = new Node(newNode.data, cur);
        //     }
        // }
        // return head;
    }

    private static void printLL(Node head) {
        if(head == null){
            System.out.println("null");
        }else{
            Node cur = head;
            while(cur != null){
                System.out.print(cur.data + "-->");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }
}
