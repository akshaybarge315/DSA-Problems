import java.util.ArrayList;

public class MostWaterContainer {
    // Brute Force Approch - n^2
    // public static int mostWaterCont(ArrayList<Integer> height){
    //     int maxWater = 0;

    //     for(int i=0; i<height.size(); i++){
    //         for(int j=0; j<height.size(); j++){
    //             int width = j-i;
    //             int ht = Math.min(height.get(i), height.get(j));
    //             int currWater = width * ht;
    //             maxWater = Math.max(currWater, maxWater);
    //         }
    //     }

    //     return maxWater;
    // }

    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp < rp){
            // Cal Water
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int currWater = ht * width;
            maxWater = Math.max(currWater, maxWater);

            // update ptr
            if(height.get(lp) < height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String args[]){
        ArrayList<Integer> height= new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // System.out.println(mostWaterCont(height));
        System.out.println(storeWater(height));
    }
}
