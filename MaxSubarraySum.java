public class MaxSubarraySum{

    public static void maxSubarraySum(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        // Calculating perfix
        prefix[0] = numbers[0];
        for(int i=1; i<numbers.length; i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }

        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){

                int curr_Sum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
                
                if (maxSum < curr_Sum){
                    maxSum = curr_Sum;
                }
            }
        }
        System.out.println("Max Sum = " + maxSum);
    }

    // Kadanes Algorithm (optimize soln of prefix)
    public static void kadanes(int numbers[]){
        int ms = Integer.MIN_VALUE;
        // current sum
        int cs = 0;

        for(int i=0; i<numbers.length; i++){
            cs = cs + numbers[i];
            if(cs < 0){
                cs = 0;
            }

            ms = Math.max(ms, cs);
        }

        // for(int i=0; i<numbers.length; i++){
        //     cs = cs + numbers[i];
        //     ms = Math.max(ms, cs);
        // }

        System.out.println("Max Sum is: " + ms);
    }
    public static void main(String args[]){
        // int numbers[] = {1, -2, 6, -1, 3};
        int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        // maxSubarraySum(numbers);
        kadanes(numbers);

    }
}