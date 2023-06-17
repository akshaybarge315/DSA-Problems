public class DoubleLL {

    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    
    //  addFirt
    public void addfirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = null;
        head = newNode;
    }

    // print
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // remove first
    public int removeFirst(){
        if(head == null){
            System.out.println("DLL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;

        return val;
    }

    // addLast
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = null;
        newNode.prev = tail;
        tail = newNode;
        
    }

    // remove Last
    public int removeLast(){
        if(head == null){
            System.out.println("DLL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node temp = head;
        int i = 0;
        while(i < size-2){
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public void reverseDLL(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;  // Extra line to reverse DLL
            prev = curr;
            curr = next;
        }

        head = prev;
    }


    public static void main(String args[]){
        DoubleLL dll = new DoubleLL();
        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);
        dll.addLast(4);
        dll.addLast(5);
        dll.print();

        // dll.removeFirst();
        // dll.print();
        
        // dll.removeLast();
        // dll.print();

        dll.reverseDLL();
        dll.print();
        System.out.println(dll.size);
    }
}
