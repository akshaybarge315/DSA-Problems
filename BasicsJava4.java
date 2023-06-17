import java.util.*;

public class BasicsJava4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number do you want to test");
        int Number = sc.nextInt();

        if(Number >= 0){
            System.out.println("Number is Positive");
        }
        else if(Number < 0){
            System.out.println("Number is Negative");
        }
        else{
            System.out.println("Enter Wrong input");
        }

    }
}
