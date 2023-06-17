import java.util.*;
import java.util.LinkedList;

public class ReverseFirstKele {
    public static void reversefirstK(Queue<Integer> q,int k){
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<k; i++){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        for(int i=0; i<k; i++){
            q.add(q.remove());
        }
    }


    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        int k = 5;

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);

        reversefirstK(q, k);
        while(!q.isEmpty()){
            System.out.print(q.remove()+ " ");
        }
    }
}
