public class MajorityElementRec {
    public static int majorityEleRec(int nums[], int si, int ei){
        // Base Case
        if(si == ei){
            return nums[si];
        }

        int mid = si + (ei-si)/2;
        int left = majorityEleRec(nums, si, mid);
        int Right = majorityEleRec(nums, mid+1, ei);

        // if Two halves agree on the majorty Element
        if(left == Right){
            return left;
        }

        // Otherwise Count each element
        int leftCount = CountInRange(nums, left, si, ei);
        int rightCount = CountInRange(nums, Right, si, ei);

        return leftCount > rightCount ? left : Right;
    }

    public static int CountInRange(int nums[],int num,int si,int ei){
        int count = 0;
        for(int i=si; i<=ei; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int nums[] = {2,2,1,1,1,2,1};

        System.out.println(majorityEleRec(nums, 0, nums.length-1));
    }
}
