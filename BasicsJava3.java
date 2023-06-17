import java.util.*;

public class BasicsJava3{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of A");
        int a = sc.nextInt();
        System.out.println("Enter the value of B");
        int b = sc.nextInt();
        System.out.println("Enter the value of C");
        int c = sc.nextInt();

        if ((a >= b) && (a >= c)){
            System.out.println("The Largest value is: " + a);
        }
        else if(b >= c){
            System.out.println("The largest value is: "+ b);
        }
        else{
            System.out.println("The Largest value is: "+ c);
        }
    }
}