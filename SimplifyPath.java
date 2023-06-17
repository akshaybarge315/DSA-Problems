import java.util.*;
public class SimplifyPath {
    public static String getSimplifyPath(String str){
        Stack<String> s1 = new Stack<String>();
        // creating empty string 
        String res = "";
        res += '/';

        for(int i=0; i<str.length(); i++){
            // if '/' comes continue
            if(i < str.length() && str.charAt(i) == '/'){
                continue;
            }

            String temp = "";
            // The string between two '/' store in temp
            while(i < str.length() && str.charAt(i) != '/'){
                temp += str.charAt(i);
                i++;
            }

            // if . comes the continue
            if(temp.equals(".") == true){
                continue;
            }
            // if .. comes delete the prev string and then continue
            else if(temp.equals("..") == true){
                if(!s1.empty()){
                    s1.pop();
                }
            }
            // Then push to Stack
            else if(temp.length() != 0){
                s1.push(temp);
            }

        }
        
        // Creating new Stack and Reverse it
        Stack<String> s2 = new Stack<String>();
        while(!s1.empty()){
            s2.push(s1.pop());
        }

        // Pop all the string 
        while(!s2.empty()){
            if(s2.size() != 1){
                res += (s2.pop() + "/");
            }else{
                res += s2.pop();
            }
        }
        return res;
    }
    public static void main(String args[]){
        String str = new String("/apanCollege/../ak/");
        String res = getSimplifyPath(str);
        System.out.println(res);
    }
}
