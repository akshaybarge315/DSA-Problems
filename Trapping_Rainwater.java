public class Trapping_Rainwater {
    
    public static int trappedRainwater(int height[]){
        int n = height.length;

        // Calculate left max boundary - auxiliary array
        int left_max[] = new int[n];
        left_max[0] = height[0];
        for(int i=1; i<n; i++){
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }

        // Calculate right max boundary - auxiliary array
        int right_max[] = new int[n];
        right_max[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            right_max[i] = Math.max(height[i], right_max[i+1]);
        } 
        
        int trappedWater = 0;
        // loop
        for(int i=0; i<n; i++){
            // water level = min ( left_max and right_max )
            int waterlevel = Math.min(left_max[i], right_max[i]);

            // trapped water = water level - height
            trappedWater += waterlevel - height[i];
        }
        return trappedWater;
     }

    public static void main(String args[]){
       int height[] = {4, 2, 0, 6, 3, 2, 5};

       System.out.println(trappedRainwater(height));    
    }
}
