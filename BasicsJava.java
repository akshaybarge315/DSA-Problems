import java.util.*;

public class BasicsJava{
    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter Value of a");
        // int a = sc.nextInt();
        // System.out.println("Enter the value of b");
        // int b = sc.nextInt();
        // // int  sum = a+b;
        // int product = a*b;

        // System.out.println("The sum of two number is " + product);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of radius");
        float radius = sc.nextFloat();

        float area = 3.14f * radius * 2;
        System.out.println("Area of circle is "+ area);

    }
}