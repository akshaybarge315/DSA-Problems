public class MaxBalanceStrPartition {
    public static void main(String args[]){
        String str = "LRRRRLLRLLRL";

        int l = 0, r = 0;
        int maxPart = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'L'){
                l++;
            }else{
                r++;
            }

            if(l == r){
                maxPart++;
            }
        }

        System.out.println("Maximum Balanced String Partition " + maxPart);
    }
}
