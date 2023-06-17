public class Keyboardcomb {
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void keypadCombination(String str, int idx, String combination){
        // Base Case
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }

        // Recursion
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '1'];

        for(int i=0; i<mapping.length(); i++){
            keypadCombination(str, idx+1, combination+mapping.charAt(i));
        }
    }


    public static void main(String args[]){
        String str = "23";
        keypadCombination(str, 0, "");
    }
}
