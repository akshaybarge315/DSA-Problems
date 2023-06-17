public class Subarray {

    public static void subArray(int numbers[]){
        int Ts = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                int sum=0;
                for(int k=i; k<=j; k++){
                    System.out.print(numbers[k]+ " ");
                    sum += numbers[k];
                    if(largest < sum){
                        largest = sum;
                    }
                    if(smallest > sum){
                        smallest = sum;
                    }
                }
                Ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total subarray is: "+ Ts);
        System.out.println("Largest addition of subarray is: "+ largest);
        System.out.println("Smallest addition of subarray is: "+ smallest);
    }
    public static void main(String args[]){
        int numbers[] = {2, 4, 6, 8, 10};

        subArray(numbers);
    }
}
