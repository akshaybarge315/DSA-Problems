public class ZigZagLL {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        // Create new Node
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }
        // newNode next = head
        newNode.next = head; //link
        
        // head - newNode
        head = newNode;
    }

    public void print(){
        Node temp = head;
        if(temp == null){
            System.out.println("LL is Empty");
        }
        while(temp != null){
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void zigZag(){
        // Find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        
        // Reverse 2nd Half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // Alternate Merging - zig-zig merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String args[]){
        ZigZagLL ll = new ZigZagLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.zigZag();
        ll.print();
    }
}
