public class Strings {
    public static void main(String args[]){
        // char arr[] = {'a','b','c','d','e'};
        // String str = "abcd";
        // String str2 = new String("abc");

        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();

        // System.out.println(name);

        // Largest String
        String Fruits[] = {"apple", "mango", "banana"};
        String largest = Fruits[0];
        for(int i=0; i<Fruits.length; i++){
            if(largest.compareTo(Fruits[i]) < 0){
                largest = Fruits[i];
            }
        }
        System.out.println(largest);


        // String Builder
        StringBuilder sb = new StringBuilder("");
        for(char ch='a'; ch<='z'; ch++){
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
