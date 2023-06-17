public class DeleteNmLL {
    public static class Node{
        int data;
        Node next;
    }

    static Node push( Node head, int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static void printList(Node head){
        Node temp = head;
        if(temp == null){
            System.out.println("LL is Empty");
        }
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void skipMdeleteN( Node head, int M, int N){
        Node curr = head, t;

        // Main Loop traverse to whole loop
        while (curr != null){

            // Skip M nodes
            for (int count = 1; count < M && curr != null; count++){    
                curr = curr.next;
            }

            // If we reched end of list, return
            if (curr == null){
                return;
            }

            // start from next node and delete N nodes
            t = curr.next;
            for (int count = 1; count <= N && t != null; count++){
                // Node temp = t;
                t = t.next;
            }
            
            // Link the previous list with remaining nodes
            curr.next = t;

            // Set Current ptr for next iteration
            curr = t;
        }
    }
    public static void main(String args[]){
        Node head = null;
        int M = 2, N = 2;

        head = push(head, 10);
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        System.out.printf("M = %d, N = %d \n" +"Linked list we have is :\n", M, N);
        printList(head);

        skipMdeleteN(head, M, N);

        System.out.print("\nLinked list on deletion is :\n");
        printList(head);

    }
}
