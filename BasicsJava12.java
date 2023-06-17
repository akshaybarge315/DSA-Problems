import java.util.*;

public class BasicsJava12 {
    public static void main(String args[]){
        System.out.println("Enter Number You want Factorial");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fact=1;

        // do{
        //     fact = 1 * (n-(n-i));
        //     i++;
        // }while(n==i);

        for(int i = 1; i <= n; i++){
            fact = fact * i;
        }

        System.out.println(fact);
    }
    
}
