package org.dsa.interface2;

class A {
    void showInclass(){
        System.out.println("in A");
    }
}

class B extends A{

    //  @Override annotation:
    //  prevent mistake and increase readability
    @Override
    void showInclass(){
        System.out.println("in B");
    }
}

// custom annotation
@interface Todo{
    String value(); // a required element
    String assignedTo() default "unassigned"; // optional
}

public class InterfaceDemo {
    public static void main(String... args){

        A a = new B();
        a.showInclass();
    }
}
