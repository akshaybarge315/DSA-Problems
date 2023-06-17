public class BasicsJava14{

    public static void binToDec(int binNum){
        int myNum = binNum;
        int dec = 0;
        int pow = 0;

        while(binNum > 0){
            int lastDigit = binNum % 10;
            dec= dec + (lastDigit * (int)Math.pow(2, pow));
            pow++;
            binNum = binNum/10;
        }

        System.out.println("decimal of "+ myNum + " = " + dec);
    }

    public static void decToBin(int n){
        int mynum = n;
        int pow = 0;
        int bin = 0;

        while(n > 0){
            int rem = n % 2;
            bin = bin + (rem * (int)Math.pow(10, pow));
            pow++; 
            n = n/2;
        }

        System.out.println("Binary of "+ mynum + "="+ bin);
    }

    public static void main(String args[]){
        decToBin(8);
    }
}