import java.util.LinkedList;

public class LinkedListCollectionFW {
    public static void main(String args[]){
        // Create
        LinkedList<Integer> ll = new LinkedList<>();

        // Add element
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addLast(2);
        System.out.println(ll);

        // Remove element
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}
