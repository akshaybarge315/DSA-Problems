import java.util.*;

public class BasicsJava8 {
    public static void main(String args[]){
        System.out.println("Enter Number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=1, sum=0;

        while (count <= n){
            sum = sum + count;
            count++;
        }

        System.out.println(sum);

    }
}
