public class RecursiveFunQ {
    
    public static void findOccu(int arr[], int idx,int key){
        if(idx == arr.length){
            return;
        }

        if(key == arr[idx]){
            System.out.print(idx+ " ");
        }
        findOccu(arr, idx+1, key);
    }

    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void stringtoEng(int num){
        if(num == 0){
            return;
        }

        // Kaam
        int lastdigit = num % 10;
        stringtoEng(num/10);
        System.out.print(digits[lastdigit] + " ");

    }

    public static int lenOfStr(String str){
        if(str.length() == 0){
            return 0;
        }
        return lenOfStr(str.substring(1)) + 1;
    }

    public static int countSubstrs(String str,int i,int j,int n) {
        if(n == 1) {
            return 1;
        }
        if(n <= 0) {
            return 0;
        }
        int res = countSubstrs(str, i+1 ,j ,n-1) + countSubstrs(str, i, j-1, n-1) - countSubstrs(str, i+1, j-1, n-2);
        
        if(str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }


    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("transfer disk "+ n + " From " + src + " to " + dest);
            return;
        }

        // src to helper using dest as helper
        towerOfHanoi(n-1, src, dest, helper);

        // Transfer Nth From src to dest
        System.out.println("transfer disk "+ n + " From " + src + " to " + dest);

        // helper to des using src as helper
        towerOfHanoi(n-1, helper,src, dest);

    }

    public static void main(String args[]){
        // First Problem
        // int arr[] = {3,2,4,5,6,2,7,2,2};
        // findOccu(arr, 0, 2);

        // Second Problem
        // stringtoEng(1947);

        // Third Problem
        // String str = "akki";
        // System.out.println(lenOfStr(str));

        // Fourth Problem
        // String str = "abcab";
        // int n = str.length();
        // System.out.println(countSubstrs(str, 0, n-1, n));

        // Fifth Problem
        int n = 3;
        towerOfHanoi(n, "A", "B", "C");
    }
}
