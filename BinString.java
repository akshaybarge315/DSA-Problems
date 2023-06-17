public class BinString {
    public static void printBinString(int n, int lastPlace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        printBinString(n-1, 0, str+"0");
        if(lastPlace == 0){
            printBinString(n-1, 1, str+"1");
        }

        // For Consecetive Zeros
        // printBinString(n-1, 1, str+"1");
        // if(lastPlace == 1){
        //     printBinString(n-1, 0, str+"0");
        // }
    }   
    
    public static void main(String args[]){
        printBinString(3, 0, "");
    }
}
