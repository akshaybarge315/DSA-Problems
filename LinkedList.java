public class LinkedList {

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
    public static int size;

    // Methods
    public void addFirst(int data){
        // Create new Node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        // newNode next = head
        newNode.next = head; //link
        
        // head - newNode
        head = newNode;
    }

    public void addLast(int data){
        // Craete new Node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        // Last node tail = newNode
        tail.next = newNode;

        // tail = newNode
        tail = newNode;
    }

    public void print(){
        Node temp = head;
        if(temp == null){
            System.out.print("LL is Empty");
        }
        while(temp != null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){
        if(idx ==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while( i < idx-1){
            temp = temp.next;
            i++;
        }

        // i = idx-1; tmep-->prev
        newNode.next = temp.next;
        temp.next = newNode; 
    }

    public int removeFirst(){
        // if LL is empty
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail =null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev : i = size-2
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        
        while(temp != null){
            if(temp.data == key){
                return i;
            }

            temp = temp.next;
            i++;
        }

        // Key is Not found
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverseLL(){
        // Declear 3 Variable
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;  //Reverse Step
            prev = curr;  // Update prev curr next
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n){
        // Calculating Size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next;  // Remove First if contains only one element.
            return;
        }

        int i=1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // Slow-Fast Approch;
    public Node findMid(Node head){  // helper Function
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; //+2
        } 

        return slow; // Slow is my mid
    }

    public boolean isPalindrome(){
        // Base Case
        if(head == null || head.next == null){
            return true;
        }

        // Step 1 : find Mid
        Node mid = findMid(head);

        // step 2 : Reverse 2nd half
        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // step 3 : check 1st half and 2nd half
        while(right != null){
            if(right.data != left.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next;  // +2
            if(slow == fast){ 
                return true;  // Cycle Exits
            }
        }
        return false;  // Cycle does not Exits
    }


    public static void removeCycle(){
        // Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            while(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        // Finding meeting point
        slow = head;
        Node prev = null;  // Last Node
        while(fast != slow){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Remove Cycle ->last.next = null;
        prev.next = null;

    }

    public static void main(String args[]){
        // LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.add(2, 9);

        // ll.print();
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);

        // For Iterative search
        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(10));

        // For recursive Search
        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.recSearch(10));

        // reverse LL
        // ll.reverseLL();
        // ll.print();

        // Delete Nth Node From End
        // ll.deleteNthFromEnd(3);
        // ll.print();

        // System.out.println(ll.isPalindrome());


        // Detect Loop/Cycle in LL
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1->2->3->2
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}
