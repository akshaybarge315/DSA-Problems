import java.util.*;

class HackerRank1{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int ans = a;
            for(int j=0; j< n; j++){
                int sum = (int) Math.pow(2, j)* b;
                ans = ans + sum;
                System.out.print(ans + " ");
            }
            System.out.println();
        }
        in.close();
    }
}