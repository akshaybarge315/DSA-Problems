public class BasicsJava16 {
    public static float avgSum(float n1, float n2, float n3){
        float avg = (n1+n2+n3)/3;
        return avg;
    }

    public static boolean isEven(int num){
        if (num % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static void isPalindrome(int num){
        int temp = num;
        int rev = 0;

        while(num != 0){
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num/10;
        }

        if(temp == rev){
            System.out.println("Number is Palindrome");
        }
        else{
            System.out.println("Number is not Palindrome");
        }
    }


    public static int sumDigits(int n) {
        int sumOfDigits=0;
        
        while(n>0) {
            int lastDigit=n % 10;
            sumOfDigits += lastDigit;
            n /= 10;
        }
        return sumOfDigits;
    }

    public static void main(String args[]){
        // System.out.println(avgSum(12.5f, 5, 11.5f));

        // System.out.println(isEven(8));

        // isPalindrome(123);

        System.out.println(sumDigits(123456));
    }
}
