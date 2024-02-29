package LinkedList;

public class PopHeadElement {
    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        // Pop Operation
        head = popOperation(head);
        printList(head);
    }

    private static Node popOperation(Node head) {
        if(head == null){
            return null;
        }else{
            int res = head.data;
            head = head.next;
            System.out.println("Popped Data is " + res);
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
