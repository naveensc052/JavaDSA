package LinkedList;

import java.util.Scanner;

public class ArrayToList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scan.nextInt();
        }
        Node head = null;
        for(int i = n-1; i>=0; i--){
            head = new Node(nums[i], head);
        }
        Node start = convert2LinkedList(nums);
        printLL(head);
        System.out.println();
        printLL(start);
        int length = lengthOfLinkedList(start);
        System.out.println();
        System.out.println("Length of Linked List is " + length);
        scan.close();
    }

    private static int lengthOfLinkedList(Node start) {
        if(start ==null){
            return 0;
        }else{
            return 1 + lengthOfLinkedList(start.next);
        }
    }

    // Optimal
    private static Node convert2LinkedList(int[] nums) {
        Node head = new Node(nums[0]);
        Node mover = head;
        for(int i=1; i<nums.length; i++){
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void printLL(Node head){
        if(head == null){
            System.out.println("Empty!");
        }
        else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "  ");
                temp = temp.next;
            }
        }
        
    }
}