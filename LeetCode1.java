public class LeetCode1 {
    public int minimumRounds(int[] tasks) {
        int j =0;
        if(tasks.length < 3){
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<tasks.length; i++){
            largest = Math.max(largest, tasks[i]);
        }
        
        int[] count = new int[largest+1];

        for(int i=0; i<tasks.length; i++){
            count[tasks[i]]++;
        }

        int min = 0;
        
        for(int i = 0; i<count.length; i++){
            if(count[i] == 1)
            {
                return -1;
            }
            else if(count[i] % 3 == 0)
            {
                min += (count[i] / 3);
            }
            else
            {
                min += (count[i] / 3)+1;
            }
        }
        return min;
    }
}
