import java.util.*;

public class FractionalKnapsack {
    public static void main(String args[]){
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        double ratio[][] = new double[weight.length][2];
        // oth col = idx:  1th col = ratio

        for(int i=0; i<value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] =  value[i]/(double)weight[i];
        }
        
        // Asscending Order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capcity = w;
        int finalVal= 0;
        for(int i=ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(capcity >= weight[idx]){
                finalVal += value[idx];
                capcity -= weight[idx];
            }else{
                // include fractional value
                finalVal += (ratio[i][1]*capcity);
                capcity = 0;
                break;
            }
        }
        System.out.println(finalVal);
    }
}
