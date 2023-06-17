import java.util.*;

public class BasicsJava9 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 2){
            System.out.println("n is a prime Number");
        }
        else{
            boolean isPrime = true;
            for (int i=2; i<= Math.sqrt(n); i++) {
            if (n % 2 == 0){
                isPrime = false;
            }
        }

        if(isPrime == true){
            System.out.println("n is a prime Number");
        }
        else{
            System.out.println("n is not a prime Number");
        }

        }

        
    }
}
