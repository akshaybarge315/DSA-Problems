import java.util.Stack;
public class DuplicateParanthesis {
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            // closing codn
            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }

                if(count < 1){
                    return true;  // Duplicate find
                }else{
                    s.pop();  // Opening pair
                }
            }else{
                // Opening codn : open backet, operand, operator 
                s.push(ch);
            }
        }
        return false;

    }

    public static void main(String args[]){
        String str = "((a+b))";
        // String str1 = "(a-b)";
        System.out.println(isDuplicate(str));
    }
}
