import java.util.*;

public class BasicsJava13 {
    
    // Only for n>=2
    public static boolean isPrime(int n){
        // Corner cases
        // 2
        if(n==2){
            return true;
        }

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void primeInRange(int n){
        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number you want to check");
        int n = sc.nextInt();
        primeInRange(n);
    }
}