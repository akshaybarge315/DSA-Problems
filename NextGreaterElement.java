import java.util.Stack;
public class NextGreaterElement {
    public static void main(String args[]){
        int arr[] = {6, 8, 0, 1, 3};
        // int arr[] = {6, 8, 5, 1, 9, 7};
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            // while loop
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            // if Codn
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            }else{
                nxtGreater[i] = arr[s.peek()];
            }

            // push in Stack
            s.push(i);
        }

        for(int i=0; i<nxtGreater.length; i++){
            System.out.print(nxtGreater[i]+ " ");
        }
        System.out.println();
    }
}
