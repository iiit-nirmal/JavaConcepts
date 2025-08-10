package org.dsa.abstraction;

interface InterfaceA {
    int age=44;
    String area="Mumbai";
    void show();
    void config();
    default void print(){
        System.out.println("Printing");
    }
    static void printInterace(){
        System.out.println("static in Interface");
    }
}

abstract class AbstractA implements InterfaceA{
    @Override
    public void show(){
        System.out.println("in AbstractA show");
    }

}

interface InterfaceB extends InterfaceA{ }

class B implements InterfaceB {

    @Override
    public void show(){
        System.out.println("in show");
    }

    @Override
    public void config(){
        System.out.println("in config");
    }
}

public class InerfaceDemo {
    public static void main(String... args){
        InterfaceA interfaceA = new B();
        interfaceA.config();
        interfaceA.show();

        InterfaceB interfaceB = new B();
        interfaceB.config();
        interfaceB.show();
    }
}
