import java.util.*;

public class string_Q {
    public static int stringVowels(String str){
        int count =0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        }
        return count;
    }

    public static void checkAnagram(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()){
            char[] str1chararray = str1.toCharArray();
            char[] str2chararray = str2.toCharArray();

            Arrays.sort(str1chararray);
            Arrays.sort(str2chararray);

            boolean result = Arrays.equals(str1chararray, str2chararray);

            if(result){
                System.out.println(str1 + " and " + str2 + " are anagram String");
            }else{
                System.out.println(str1 + " and " + str2 + " are not anagram String");
            }

        }else{
            System.out.println(str1 + " and " + str2 + " are not anagram String");
        }
    }

    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);
        // String str = sc.next();
        // System.out.println(stringVowels(str));


        String str1 = "earth";
        String str2 = "heart";
        checkAnagram(str1, str2);
    }
}
