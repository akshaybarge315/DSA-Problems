import java.util.Stack;
public class IsPalindromeStack {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    static Node tail;

    static boolean isPalindrome(Node head){
        Node temp = head;
        Stack<Integer> s = new Stack<>();
        while(temp != null){
            s.push(temp.data);
            temp = temp.next;
        }

        while(head != null){
            if(head.data != s.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String args[]){
        Node n1 = new Node(10);
        Node n2 = new Node(5);
        Node n3 = new Node(15);
        Node n4 = new Node(5);
        Node n5 = new Node(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        boolean result = isPalindrome(n1);
        System.out.println(result);
    }
}
