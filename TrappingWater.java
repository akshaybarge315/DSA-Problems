public class TrappingWater{

    public static int trappedWater(int height[]){
        // Left max of trapping water
        int left_max[] = new int[height.length];
        left_max[0] = height[0];
        for(int i=1; i<height.length; i++){
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }

        // right max of trapping water
        int right_max[] = new int[height.length];
        right_max[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }

        int trappedwater = 0; 
        // loop
        for(int i=0; i<height.length; i++){
            // waterlevel = min( left_max, right_max)
            int waterlevel = Math.min(left_max[i], right_max[i]);

            // trapped water = waterlevel - height
            trappedwater += waterlevel - height[i];
        }
        return trappedwater;
        
    }
    

    public static void main(String args[]){
        int height[] = {4,2,0,6,3,2,5};

        System.out.println(trappedWater(height));
    }
}