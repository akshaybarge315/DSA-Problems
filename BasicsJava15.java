public class BasicsJava15 {

    public static void binToDec(int binNum){
        int myNum = binNum;
        int dec = 0;
        int pow = 0;

        while(binNum >0){
            int rem = binNum % 10;
            dec = dec + (rem * (int) Math.pow(2, pow));
            pow++;
            binNum = binNum/10;
        }

        System.out.println("Decimal of " +  myNum + "= " + dec);
    }

    public static void decToBin(int decNum){
        int myNum = decNum;
        int bin = 0;
        int pow = 0;

        while(decNum > 0){
            int rem = decNum % 2;
            bin = bin + (rem * (int)Math.pow(10, pow));
            pow++;
            decNum = decNum/2;
        }

        System.out.println("Binary of "+ myNum + "= " + bin);
    }

    public static void main(String args[]){
        decToBin(10);
    }
}
