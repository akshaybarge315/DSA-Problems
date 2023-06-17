class OOPSQ{
    public static void main(String args[]){
        Complex c = new Complex(4,5);
        Complex d = new Complex(9,4);

        Complex e = Complex.add(c,d);
        Complex f = Complex.diff(c,d); 
        Complex g = Complex.product(c,d); 

        e.printcomplex();
        f.printcomplex();
        g.printcomplex();
    }
}

class Complex{
    int realNum;
    int imgNum;

    public Complex(int r, int i){
        realNum = r;
        imgNum = i;
    }

    public static Complex add(Complex a, Complex b){
        return new Complex ((a.realNum+ b.realNum),(a.imgNum + b.imgNum));
    }

    public static Complex diff(Complex a, Complex b){
        return new Complex ((a.realNum - b.realNum),(a.imgNum - b.imgNum));
    }

    public static Complex product(Complex a, Complex b){
        return new Complex ((a.realNum * b.realNum)-(a.imgNum * b.imgNum), (a.realNum * b.realNum)+(a.imgNum * b.imgNum));
    }

    public void printcomplex(){
        if(realNum == 0 && imgNum != 0){
            System.out.println(imgNum + "i");
        }
        else if(imgNum == 0 && realNum != 0){
            System.out.println(realNum);
        }
        else{
            System.out.println(realNum+"+"+imgNum+"i");
        }
    }
}
