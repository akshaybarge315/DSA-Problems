public class RecursiveFun {

    public static void toDecOrder(int n){
        if(n == 1){
            System.out.print(1);
            return;
        }
        System.out.print(n + " ");
        toDecOrder(n-1);
    }

    public static void toIncOrder(int n){
        if(n == 1){
            System.out.print(1);
            return;
        }
        toIncOrder(n-1);
        System.out.print(" "+ n);
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int Fnm1 = factorial(n-1);
        int fac = n * Fnm1;
        return fac;
    }

    public static int calNSum(int n){
        if(n == 1){
            return 1;
        }
        int Snm1 = calNSum(n-1);
        int Sn = n + Snm1;
        return Sn;
    }

    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int Fnm1 = fibonacci(n-1);
        int Fnm2 = fibonacci(n-2);
        int fib = Fnm1 + Fnm2;
        return fib;
    }

    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOcc(int arr[], int key, int i){
        if(i == arr.length-1){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOcc(arr, key, i+1);
    }

    public static int lastOcc(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        int isfound = lastOcc(arr, key, i+1);
        if(isfound == -1 && arr[i] == key){
            return i;
        }
        return isfound;
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        // int Xnm1 = power(x, n-1);
        // int Xn = x * Xnm1;
        // return Xn;

        return x * power(x, n-1);
    }

    public static int optimizedPower(int x, int n){
        if(n == 0){
            return 1;
        }
        int halfPower = optimizedPower(x, n/2);
        int halfPowerSq = halfPower * halfPower;
        // For odd case
        if(n % 2 != 0){
            halfPowerSq = x * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String args[]){
        // int n = 5;
        // toDecOrder(n);
        // toIncOrder(n);

        // System.out.println(factorial(n));
        // System.out.print(calNSum(n));
        // System.out.print(fibonacci(n));

        // int arr[] = {1, 2, 3, 4, 5, 4};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(lastOcc(arr, 4, 0));

        // System.out.print(power(2, 10));
        System.out.print(optimizedPower(2, 5));
    }
}
