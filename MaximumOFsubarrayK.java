import java.util.*;
import java.util.ArrayDeque;

public class MaximumOFsubarrayK {
    // Brute Froce method
    public static void maxSubArrayK(int arr[],int n, int k){

        for(int i=0; i<= n-k; i++){
            int max = arr[i];    // TC: O(n*k)
            for(int j = 1; j<k; j++){
                if(arr[i+j] > max){
                    max =  arr[j+i];
                }
            }
            System.out.print(max + " ");
        }
        System.out.println();
    }

    // Using Deque
    public static void printMax(int arr[], int n, int k){
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int i=0;

        // Process first k (or first window)
        for(; i<k; ++i){

            // for every element, the previous 
            // smaller element are useless so remove them from deque
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                deque.removeLast();
            }

            // add element at rear of queue  
            deque.addLast(i);
        }

        // process rest of the element 
        for(; i<n; ++i){
            // The ele at the front of queue is the largest ele of prev window
            // Print it
            System.out.print(arr[deque.peek()] + " ");

            // Remove ele which out of this window'
            while((!deque.isEmpty()) && deque.peek() <= i-k){
                deque.removeFirst();
            }

            // remove all ele smaller than the currently being added ele 
            // remove useless elements
            while((!deque.isEmpty()) && arr[i] >= arr[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(i);
        }
        // print last element
        System.out.print(arr[deque.peek()]);

    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        maxSubArrayK(arr,arr.length, k);
        printMax(arr, arr.length, k);
        
    }
}
