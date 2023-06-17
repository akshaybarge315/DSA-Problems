public class Sorting_question {

    public static void bubbleSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                // Descending order
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    public static void printarr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectioSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int smallest = i;
            for(int j=i+1; j<arr.length; j++){
                // Descending order
                if(arr[smallest] < arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void inserationSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            int curr = arr[i];
            int j = i-1;
            // Descending order
            while(j >= 0 && arr[j] < curr){
                arr[j+1] = arr[j];
                j--;
            }
            // Sorting
            arr[j+1] = curr;
        }
    }

    public static void countingSort(int arr[]){
        // largest number
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }

        //Creating array and count
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        } 

        // assign into Original
        // Reverse Array i.e Descending order
        int j=arr.length-1;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j--;
                count[i]--;
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {3,6,2,1,8,7,4,5,3,1};

        // bubbleSort(arr);
        // selectioSort(arr);
        // inserationSort(arr);
        countingSort(arr);
        printarr(arr);
    }
}
