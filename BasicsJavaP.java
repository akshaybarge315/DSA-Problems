public class BasicsJavaP {

    public static void hollow_rect(int totRows, int totCols){
        for(int i=1; i<=totRows; i++){
            for(int j=1; j<=totCols; j++){
                if(i==1 || i==totRows || j==1 || j==totCols){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    public static void half_pyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int k=1; k<=i; k++){
                System.out.print("*");
            }

            System.out.println();
            
        }
    }

    public static void half_pyramid_Number(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i+1; j++){
                System.out.print(j);
            }

            System.out.println();
        }
    }

    public static void floyds_tri(int n){

        int num= 1;
        for(int i=1;i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(num+" ");
                num++;
            }

            System.out.println();
        }
    }

    public static void zero_One_tri(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if ( (i+j) % 2 ==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }

            System.out.println();
        }
    }

    public static void Butterfly_pattern(int n){
        // first half
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            for(int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
    
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();            
        }
        
        // Second half
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            for(int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
    
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void soild_rombus(int n){
        for(int i=1;i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int k=1; k<=n; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rombus(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int j=1; j<=n; j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    public static void dimond_pattern(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int k=1; k<=(2*i)-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n; i>=1; i--){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int k=1; k<=(2*i)-1; k++){
                System.out.print("*");
            }
            System.out.println();            
        }
    }

    public static void main(String args[]){
        hollow_rect(9, 5);
        // half_pyramid(4);
        // half_pyramid_Number(10);
        // floyds_tri(5);
        // zero_One_tri(4);
        // Butterfly_pattern(5);
        // soild_rombus(7);
        // hollow_rombus(7);
        // dimond_pattern(4);
    }
}
