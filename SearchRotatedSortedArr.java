public class SearchRotatedSortedArr {

    public static int search(int arr[], int tar, int si, int ei){
        // Base case
        if(si > ei){
            return -1;
        }

        // Kaam
        // find mid
        int mid = si+(ei-si)/2; // (si+ei)/2

        // check mid = tar
        if(arr[mid] == tar){
            return mid;
        }

        // mid on L1
        if(arr[si] <= arr[mid]){
            // Case a : Left
            if(arr[si] <= tar && tar <= arr[mid]){
                return search(arr, tar, si, mid-1);
            }
            // case b : Right
            else{
                return search(arr, tar, mid+1, ei);
            }
        }

        // mid on L2
        else{
            // Case c : Right
            if(arr[mid] <= tar && tar <= arr[ei]){
                return search(arr, tar, mid+1, ei);
            }
            // case d : Left
            else{
                return search(arr, tar, si, mid-1);
            }
        }

    }
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
        int tarIdx = search(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);
    }
}
