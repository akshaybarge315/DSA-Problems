public class SwappingNodeLL {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void swapNodes(int x, int y){
        // Both nodes are equals
        if(x == y){
            return;
        }

        // find x data Node 
        Node prev1 = null;
        Node curr1 = head;
        while(curr1 != null && curr1.data != x){
            prev1 = curr1;
            curr1 = curr1.next;
        }

        // find y data Node 
        Node prev2 = null;
        Node curr2 = head;
        while(curr2 != null && curr2.data != y){
            prev2 = curr2;
            curr2 = curr2.next;
        }

        // if Both are null
        if(curr1 == null ||curr2 ==null){
            return;
        }

        // Pointing the previous Nodes
        if(prev1 != null){
            prev1.next = curr2;
        }else{
            head = curr2;
        }

        if(prev2 != null){
            prev2.next = curr1;
        }else{
            head = curr1;
        }

        // Pointing the x and y node
        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;
    }


    public static void main(String args[]){
        SwappingNodeLL llist = new SwappingNodeLL();

        llist.addFirst(7);
        llist.addFirst(6);
        llist.addFirst(5);
        llist.addFirst(4);
        llist.addFirst(3);
        llist.addFirst(2);
        llist.addFirst(1);

        llist.print();
        llist.swapNodes(2, 4);
        llist.print();
    }
}
