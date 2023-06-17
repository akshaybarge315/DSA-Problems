import java.util.*;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String args[]){
        int stream[] = {10,20,11,70,50,40,100,5};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i<k; i++){
            pq.add(stream[i]);
        }

        for(int i=k; i<stream.length; i++){
            System.out.print(pq.peek() + " ");
            if(pq.peek() < stream[i]){
                pq.poll();
                pq.add(stream[i]);
            }
        }
    }
}
