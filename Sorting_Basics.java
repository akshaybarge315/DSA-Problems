import java.util.Arrays;
import java.util.Collections;

public class Sorting_Basics {

    public static void bubbleSort(int arr[]){
        for(int turn=0; turn<arr.length-1; turn++){
            int swap = 0;
            for(int j=0; j<arr.length-1-turn; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;
                }
            }
            // for checking if number already sorted or not
            if(swap == 0){
                break;
            }
        }
    }

    public static void printarr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectioSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp; 
        }
    }

    public static void inserationSort(int arr[]){
        // outer loop for Unsorted array
        for(int i=1; i<arr.length;i++){
            int curr = arr[i];
            int j=i-1;
            // Inner loop for sorrted array
            while(j>=0 && arr[j] > curr){
                arr[j+1] = arr[j];
                j--;
            }

            // inseration 
            arr[j+1] = curr;

        }
    }

    public static void countingSort(int arr[]){
        // Getting largest number
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }

        // Counting Frequncy
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }

        // Sorting
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }            
        }
    }

    public static void main(String args[]){
        // Integer arr[] = {5,3,4,1,2};
        int arr[] = {1,4,1,3,2,4,3,7};

        bubbleSort(arr);
        // selectioSort(arr);
        // inserationSort(arr);

        // INBUILD FUNCTION TO SORT ARRAY
        // Arrays.sort(arr);

        // SORTING ARRAYS BASED ON INDEX
        // Arrays.sort(arr, 0, 3);

        // Sorting Array in decending order --- chgange type int to Integer
        // Arrays.sort(arr, Collections.reverseOrder());

        // Sorting Array in decending order with Index
        // Arrays.sort(arr,0 , 3 ,Collections.reverseOrder());

        // Counting Sort
        // countingSort(arr);
        printarr(arr);
    }
}
