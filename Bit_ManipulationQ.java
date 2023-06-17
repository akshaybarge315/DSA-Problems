public class Bit_ManipulationQ {

    public static void swaping(int a, int b){

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        // Same using addition & Sub
        // a = a + b;
        // b = a - b;
        // a = a + b; 

        System.out.println("a = " + a + " and b = "+ b );
    }

    public static void toLowerCase(){
        for(char ch ='A'; ch<='Z'; ch++){
            System.out.print((char) (ch | ' '));
        }
    }

    public static void main(String args[]){
        int a =5;
        int b =4;

        swaping(a, b);

        // Second Problem
        int x=6;
        System.out.println(x+" + "+1+" is "+-~x);
        x= -4;
        System.out.println(x+" + "+1+" is "+-~x);
        x=0;
        System.out.println(x+" + "+1+" is "+-~x);


        // Third Problem;
        toLowerCase();
    }
}
