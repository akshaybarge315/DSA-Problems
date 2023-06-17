public class MergeSort {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int arr[], int si, int ei){
        // Base Case
        if(si >= ei){
            return;
        }
        // Kaam
        int mid = si+(ei-si)/2; // or (si+ei)/2
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        // tmep array
        int temp[] = new int[ei - si + 1];
        int i = si; //idx for 1st sorted part
        int j = mid+1; //idx for 2nd sorted part
        int k = 0; //idx for temp;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        // for leftover element of 1st array
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        // for leftover element of 2nd array
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        // Copy temp to orginal
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]){
        int arr[] = {6,3,9,5,2,8,-2};

        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}