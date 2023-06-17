class OOPSstatic{
    public static void main(String args[]){
        StudentI s1 = new StudentI();
        s1.SchoolName = "SSV";

        StudentI s2 = new StudentI();
        System.out.println(s2.SchoolName);

        StudentI s3 = new StudentI();
        s3.SchoolName = "No School";
        System.out.println(s2.SchoolName);

        System.out.println(s1.returnPercentage(50,40,60));


    }
}

class StudentI {

    static int returnPercentage(int phy, int math,int chem){
        return (phy + math + chem)/3;
    }

    String name;
    int roll_no;

    static String SchoolName;

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
}