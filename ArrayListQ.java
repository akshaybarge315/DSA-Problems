import java.util.ArrayList;
import java.util.Collections;
public class ArrayListQ {
    public static boolean monotonicArrayList(ArrayList<Integer> list){
        boolean inc = true;
        boolean dec = true;
        for(int i = 0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                inc = false;
            }
            if(list.get(i) < list.get(i+1)){
                dec = false;
            }
        }
        return inc || dec;
    }

    public static ArrayList<Integer> lonelyNumbers(ArrayList<Integer> nums){
        Collections.sort(nums);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<nums.size()-1; i++){
            if(nums.get(i-1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i+1)){
                list.add(nums.get(i));
            }
        }

        // Case 1: If size of nums is 1
        if(nums.size() == 1){
            list.add(nums.get(0));
        }

        if(nums.size() > 1){
            // Case 2:for first element
            if(nums.get(0) + 1 < nums.get(1)){
                list.add(nums.get(0));
            }
            // Case 3: for last element.
            if(nums.get(nums.size()-2) + 1 < nums.get(nums.size()-1)){
                list.add(nums.get(nums.size()-1));
            }
        }

        return list;
    }


    public static int mostFrequent(ArrayList<Integer> nums, int key){
        int result[] = new int[1000];

        for(int i=0; i<nums.size()-1; i++){
            if(nums.get(i) == key){
                result[nums.get(i+1)-1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i=0; i<1000; i++){
            if(result[i] > max){
                max = result[i];
                ans = i+1;
            }
        }
        return ans;
    }


    public static ArrayList<Integer> beautifulArray(int n){
        ArrayList<Integer> res = new ArrayList<>();
        divideconqure(1, 1, res, n);
        return res;
    }

    public static void divideconqure(int start, int increment, ArrayList<Integer> res, int n){
        // Base Case
        if(start + increment > n){
            res.add(start);
            return;
        }

        divideconqure(start,2 * increment, res, n);
        divideconqure(start + increment,2 * increment, res, n);

    }

    public static void main(String args[]){
        // Question 1;
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(2);
        // list.add(3);
        // System.out.println(monotonicArrayList(list));

        // Quwestion 2
        // ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(10);
        // nums.add(6);
        // nums.add(5);
        // nums.add(8);

        // System.out.println(lonelyNumbers(nums));

        // Question 3
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);
        int key = 1;
        
        System.out.println(mostFrequent(nums, key));

        System.out.println(beautifulArray(5));
    }
}
