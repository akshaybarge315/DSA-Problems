import java.util.Stack;

public class MaxRecArea {
    public static void maxArea(int arr[]){
        int maxarea = 1;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // next samllest right
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // next samllest left
        s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Current Area : width = j-i-1   i.e  nsr[i]-nsl[i]-1
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height * width;
            maxarea = Math.max(maxarea, currArea);
        } 

        System.out.println("Maximum Area of Histogram is " + maxarea);

    }

    public static void main(String args[]){
        int arr[] = {2, 1, 5, 6, 2, 3};
        maxArea(arr);
    }
}
