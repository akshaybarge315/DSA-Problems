public class LongestSubarray {

    static int maxL = 0;
    static int sum =0;
    static int start = 0;
    public static int findLS(int arr[], int k){
        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if(sum >= k * (i - start +1)){
                if((i - start + 1) > maxL){
                    maxL = i - start + 1;
                }
            }else{
                sum -= arr[start];
                start++;
            }
        }
        return maxL;
    }

    public static void main(String args[]){
        int arr[] = {2, 1, 4, 2, 3};
        int k=2;

        System.out.println(findLS(arr, k));
    }
}
