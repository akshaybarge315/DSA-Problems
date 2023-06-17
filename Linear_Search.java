public class Linear_Search {

    public static int linear_search(int numbers[], int key){
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == key){
                return i;
            }
        }

        return -1;
    }

    public static int linear_list(String my_list[], String key){
        for(int i=0; i<my_list.length; i++){
            if(my_list[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        // int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int key = 10;

        // int index = linear_search(numbers, key);
        // if(index == -1){
        //     System.out.println("Number Not found");
        // }else{
        //     System.out.println("Number Found at index "+ index);
        // }

        String my_list[] = {"Vadapaav", "frouti", "ice-Cream", "samosa"};
        String key= "samosa";

        int index = linear_list(my_list, key);
        if(index == -1){
            System.out.println("Meanu Not found");
        }else{
            System.out.println("Meanu Found at index "+ index);
        }
    }
    
}
