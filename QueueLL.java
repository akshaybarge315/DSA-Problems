public class QueueLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null & tail == null;
        }

        public static void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue id Empty");
                return -1;
            }

            int front = head.data;
            // if Only one element is present
            if(tail == head){
                tail = head = null;
            } else{
                head = head.next;
            }

            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]){
        Queue ql = new Queue();
        ql.add(1);
        ql.add(2);
        ql.add(3);
        ql.add(4);

        while(!ql.isEmpty()){
            System.out.println(ql.peek());
            ql.remove();
        }

    }
}
