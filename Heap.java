import java.util.*;

public class Heap {

    static class heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            // add at last index
            arr.add(data);

            int x = arr.size()-1; // x is child index
            int par = (x-1)/2;  // parent index

            while(arr.get(x) < arr.get(par)){
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int Midx = i;

            if(left < arr.size() && arr.get(Midx) > arr.get(left)){
                Midx = left;
            }

            if(right < arr.size() && arr.get(Midx) > arr.get(right)){
                Midx = right;
            }

            if(Midx != i){
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(Midx));
                arr.set(Midx, temp);

                heapify(Midx);
            }
        }    

        public int remove(){
            int data = arr.get(0);

            // Swap the first and last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Delete last node
            arr.remove(arr.size()-1);

            // Heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    
    public static void main(String args[]){
        heap h = new heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){  // heap sort - O(nlogn)
            System.out.println(h.peek());
            h.remove();
        }
    }
}
