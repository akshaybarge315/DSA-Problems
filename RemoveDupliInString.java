import java.util.*;
public class RemoveDupliInString {

    public static void removeDupli(String str, int idx, StringBuilder newString, boolean map[]){
        // Base Case
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }

        // Kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            // duplicates
            removeDupli(str, idx+1,newString, map);
        }else{
            map[currChar - 'a'] = true;
            removeDupli(str, idx+1,newString.append(currChar), map);
        }
    }
    
    public static void main(String args[]){
        String str = "appnnacollege";
        removeDupli(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
