import java.util.Scanner;

public class TwoDArray {

    public static boolean search(int matrix[][], int key){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.println("Found at cell (" + i +","+j+")");
                    return true;
                }
            }
        }
        System.out.println("Key not Found!");
        return false;
    }

    public static void largest(int matrix[][]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(largest < matrix[i][j]){
                    largest = matrix[i][j];
                }
            }
        }
        System.out.println("largest Value is "+ largest);
    }

    public static void smallest(int matrix[][]){
        int samllest = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(samllest > matrix[i][j]){
                    samllest = matrix[i][j];
                }
            }
        }
        System.out.println("samllest Value is "+ samllest);
    }

    public static void main(String args[]){
        int matrix[][] =  new int[3][3];
        int n= matrix.length, m= matrix[0].length;
        
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        search(matrix, 5);
        largest(matrix);
        smallest(matrix);
    } 
}
