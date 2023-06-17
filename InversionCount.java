public class InversionCount {

    // Basics Approch
    public static int CountInv(int arr[]){
        int count = 0;
        for(int i = 0; i<=arr.length-1; i++){
            for(int j = i+1; j<=arr.length-1; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }

    // MODIFY MERGE SORTED APPROACH    
    public static int mergeSort(int arr[], int left, int right){
        int inv = 0;

        if(right > left){
            // Kaam
            int mid = (right + left)/2; // or (si+ei)/2
            inv += mergeSort(arr, left, mid);
            inv += mergeSort(arr, mid+1, right);

            inv += merge(arr, left, mid+1, right);
        }

        return inv;
    }
    
    public static int merge(int arr[], int left, int mid, int right){
        // tmep array
        int temp[] = new int[right - left + 1];
        int i = left; //idx for 1st sorted part
        int j = mid; //idx for 2nd sorted part
        int k = 0; //idx for temp;
        int inv = 0;
    
        while(i < mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                // arr[i], arr[i+1], arr[i+2],....> arr[j] and i < j
                inv += (mid - i);
                j++;
            }
            k++;
        }
            
        // for leftover element of 1st array
        while(i < mid){
            temp[k++] = arr[i++];
        }
    
        // for leftover element of 2nd array
        while(j <= right){
            temp[k++] = arr[j++];
        }
    
        // Copy temp to orginal
        for(k=0, i=left; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
        return inv;
    }
    
    public static int getInversion(int arr[]){
        return mergeSort(arr, 0, arr.length-1);
    }
    
    public static void main(String args[]){
        int arr[] = {2,4,1,3,5};
        // System.out.println(CountInv(arr));

        System.out.println(" Inversion Count = " + getInversion(arr));
    }
}
