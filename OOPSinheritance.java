public class OOPSinheritance {
    public static void main(String args[]){
        // Fish shark = new Fish();
        // shark.eat();

        // Dog tom = new Dog();
        // tom.eat();
        // tom.legs = 4;
        // System.out.println(tom.legs); 

        Cat puppy = new Cat();
        puppy.color = "White-Black";
        System.out.println(puppy.color);
        puppy.legs = 4;
        System.out.println(puppy.legs);
    }
}

// Base class
class Animal{
    String color;

    void eat(){
        System.out.println("Eats");
    }

    void breath(){
        System.out.println("Breathes");
    }
}

// Multi level Inheritence
// class Mamal extends Animal{
//     int legs;
// }

// class Dog extends Mamal{
//     String breed;
// }

// Hierarchical Inheritance
// class Mamal extends Animal{
//     int legs;
// }

// class Fish extends Animal{
//     void swim(){
//         System.out.println("Swim");
//     }
// }

// class Bird extends Animal{
//     void fly(){
//         System.out.println("Can Fly");
//     }
// }

// Hybrid Inheritance
class Fish extends Animal{
    void swim(){
        System.out.println("Swim");
    }
}

class Tana extends Fish{
    void wing(){
        System.out.println("Fly");
        
    }
}

class Shark extends Fish{
    int teeth;
}

class Bird extends Animal{
    void fly(){
        System.out.println("Can Fly");
    }
}

class Peacock extends Bird{
    int fethers;
}

class Mammal extends Animal{
    int legs;
}

class Dog extends Mammal{
    String bread;
}

class Cat extends Mammal{
    String color;
}


// Derived Class / Subclass
// class Fish extends Animal {
//     int fins;

//     void swim(){
//         System.out.println("Swim in Water");
//     }
// }