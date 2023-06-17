public class OOPS {
    public static void main(String args[]){
        // Pen p1 = new Pen();
        // p1.setColor("Blue");
        // p1.setTip(5);
        // System.out.println(p1.getColor());
        // System.out.println(p1.getTip());
        // p1.setColor("Yellow");
        // System.out.println(p1.getColor());


        Student s1 = new Student();
        Student s2 = new Student("Akki", 123);
        s2.marks[0] = 90;
        s2.marks[1] = 80;
        s2.marks[2] = 100;
        System.out.println(s2.name);
        System.out.println(s2.roll);

        Student s3 = new Student(s2);   // Copy
        s2.marks[1] = 70;
        for(int i=0; i<3; i++){
            System.out.println(s3.marks[i]);
        }


        // BankAccount myacc = new BankAccount();
        // myacc.username = "AkkiBarge";
        // myacc.setPassword("Akki@123");
        // System.out.println(myacc.username);
        // System.out.println(myacc.password);

    }
}

class Student {
    String name;
    int roll;
    int marks[];

    //Shallow Copy Constructor
    // Student(Student s2){
    //     marks = new int[3];
    //     this.name = s2.name;
    //     this.roll = s2.roll;
    //     this.marks = s2.marks;
    // }

    // Deep Copy Constructor
    Student(Student s2){
        marks = new int[3];
        this.name = s2.name;
        this.roll = s2.roll;
        for(int i=0; i<marks.length; i++){
            this.marks[i] = s2.marks[i];
        }
    }

    Student(){
        System.out.println("Constructor is called...");
    }
    Student(String name, int roll){
        marks = new int[3];
        this.name = name;
        this.roll = roll;
    }
}

class Pen{
    private String color;
    private int tip;

    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }

    void setColor(String color){
        this.color = color;
    }

    void setTip(int tip){
        this.tip = tip;
    }
}

class BankAccount {
    public String username;
    protected String password;

    public void setPassword(String pwd){
        password = pwd;
    }
}