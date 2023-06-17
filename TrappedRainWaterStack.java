import java.util.Stack;
public class TrappedRainWaterStack {
    public static int maxWater(int[] height){
        Stack<Integer> s = new Stack<>();
        int nxtGreaterR[] = new int[height.length];

        for(int i=height.length-1; i>=0; i--){
            if(s.isEmpty()){
                s.push(i);
            }
            if(height[s.peek()] > height[i]){
                nxtGreaterR[i] = height[s.peek()];
                // push in Stack
                s.push(s.peek());
            }else{
                nxtGreaterR[i] = height[i];
                s.push(i);
            }  
        }

        s = new Stack<>();
        int nxtGreaterL[] = new int[height.length];
        for(int i=0; i<height.length; i++){
            if(s.isEmpty()){
                s.push(i);
            }
            if(height[s.peek()] > height[i]){
                nxtGreaterL[i] = height[s.peek()];
                // push in Stack
                s.push(s.peek());
            }else{
                nxtGreaterL[i] = height[i];
                s.push(i);
            }  
        }

        int trappedWater = 0;
        for(int i=0; i<height.length; i++){
            int min_height = Math.min(nxtGreaterL[i], nxtGreaterR[i]);
            trappedWater += min_height - height[i]; 
        }

        return trappedWater;


        // Stack<Integer> stack = new Stack<>();
        // int n = height.length;
        // int trappedWater = 0;
        // for (int i = 0; i < n; i++) {
        //     while ((!stack.isEmpty()) && (height[stack.peek()] < height[i])) {
        //         int pop_height = height[stack.peek()];
        //         stack.pop();
        //         if (stack.isEmpty()){
        //             break;
        //         }
        //         int distance = i - stack.peek() - 1;
        //         int min_height= Math.min(height[stack.peek()],height[i])- pop_height;
        //         trappedWater += distance * min_height;
        //     }
        //     stack.push(i);
        // }
        // return trappedWater;
    }

    public static void main(String args[]){
        int arr[] = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println(maxWater(arr));
    }
}
