public class OddEvenLL {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public Node evenOdd(Node data){
        if(head == null || head.next == null){
            return head;
        }

        Node oddH = null, oddT = null, evenH = null, evenT = null;

        while(head != null){
            if(head.data%2 == 0){
                if(evenH == null){
                    evenH = head;
                    evenT = head;
                }else{
                    evenT.next = head;
                    evenT = evenT.next;
                }
            }else{
                if(oddH == null){
                    oddT = oddH = head;
                }else{
                    oddT.next = head;
                    oddT = oddT.next;
                }
            }
            head = head.next;
        }

        evenT.next = oddH;
        oddT.next = null;
        head = evenH;
        
        return head;
    }

    public static void main(String args[]){
        OddEvenLL llist = new OddEvenLL();

        llist.addFirst(6);
        llist.addFirst(1);
        llist.addFirst(4);
        llist.addFirst(5);
        llist.addFirst(10);
        llist.addFirst(12);
        llist.addFirst(8);
        
        llist.print();
        llist.evenOdd(head);
        llist.print();

    }
}
