import java.util.*;

public class BasicsJavaP3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number You to print Butterfly");
        int n= sc.nextInt();

        // First upper triangle
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
        
            for(int space=1; space<= n-i; space++){
                System.out.print("  ");
            }

            for(int k=1; k<=i; k++){
                System.out.print("*");
            }

            System.out.println();            
        }

        // Second Lower triangle
        for(int l=1; l<=n; l++){
            for(int j=1; j<=n-l+1; j++){
                System.out.print("*");
            }

            for(int space=1; space<= l-1; space++){
                System.out.print("  ");
            }

            for(int k=1; k<=n-l+1; k++){
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
