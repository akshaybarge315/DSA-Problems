public class SplitIntokSubArray {

    public static int ans = 10000000;
    public static void solve(int arr[], int n, int k, int idx, int sum, int maxSum){
        if(k == 1){
            maxSum = Math.max(sum, maxSum);
            sum = 0; 
            for(int i = idx; i<n; i++){
                sum += arr[i];
            }

            maxSum = Math.max(sum, maxSum);
            ans = Math.min(ans, maxSum);
            return; 
        }

        sum = 0; 
        for(int i = idx; i<n; i++){
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            solve(arr, n, k-1, idx+1, sum, maxSum);
        }
    }

    public static void main(String args[]){
        int arr[] = {1, 1, 2};
        int k = 2;
        int n = 3;

        solve(arr, n, k, 0, 0, 0);
        System.out.println(ans);
    }
}
