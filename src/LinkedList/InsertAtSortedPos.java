package LinkedList;

import java.util.Scanner;

public class InsertAtSortedPos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node head = null;
        Node mover = null;
        while(true){
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
        System.out.println("Before:-");
        printList(head);
        System.out.println("Enter the element to Insert:- ");
        int element = scan.nextInt();
        head = insertToReqPos(head, element);
        System.out.println("After:-");
        printList(head);
        scan.close();
        
    }

    private static Node insertToReqPos(Node head, int element) {
        if(head == null){
            return new Node(element, null);
        }else{
            Node prev = null;
            Node curNode = head;
            while(curNode != null && element> curNode.data ){
                prev = curNode;
                curNode = curNode.next;
            }
            if(curNode == null){
                prev.next = new Node(element, null);
            }else{
                prev.next = new Node(element, curNode);
            }
            return head;
        }
    }

    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null){
            System.out.print(ptr.data + " --> ");
            ptr = ptr.next;
        }
         System.out.println("null");
    }
}
