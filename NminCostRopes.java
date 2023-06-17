import java.util.*;
public class NminCostRopes {
    public static int minCost(int a[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<a.length; i++){
            pq.add(a[i]);
        }

        int ans = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll(); 
            int sum = first + second;
            ans += sum;
            pq.add(sum);
        }
        return ans;
    }

    public static void main (String args[]){
        int a[] = {4,3,2,6};

        System.out.println(minCost(a));
    }
}
