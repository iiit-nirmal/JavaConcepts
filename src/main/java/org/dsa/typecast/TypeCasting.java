package org.dsa.typecast;

class A{
    public void show(){
        System.out.println("in A");
    }
}

class  B extends A{

    @Override
    public void show(){
        System.out.println("in B");
    }
}

abstract class Animal {
    public abstract void sound();
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Bow Bow ");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow Meow");
    }
}

public class TypeCasting {
    public static void main(String... args){
        // UpCasting , implicit , safe
        A obj1 = new B();
        obj1.show();  // in case of method overriding , call happen to child function show

        // Down Casting --> explicit, not safe(can throw ClassCastException)
        B obj2 = (B) obj1;
        obj2.show();

        // another way
        Animal a = new Cat();

        if(a instanceof Dog){
            System.out.println("true");
            // Causes Class Exception
            Dog d = (Dog) a;
            a.sound();
        }


    }
}
