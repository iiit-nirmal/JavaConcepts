package org.dsa.innerclass;
import java.util.Map;


class Outer{
    int deptId;
    static int maxHours;

    static  {
        maxHours=10;
    }
    class Inner{
        void msg(){
            System.out.println("Inner Class");
        }
    }

    static class StaticInner{
        void show(){
            System.out.println("Static Inner Class");
            System.out.println(maxHours);
        }
    }

    static void display(){
        System.out.println(" Outer A static method");
        System.out.println(maxHours);
    }
}

class A {
    void show(){
        System.out.println("Hello from A");
    }
}

class B extends A{
    @Override
    void show(){
        System.out.println("Hello from B");
    }
}

// anonymous with abstract class

abstract class C{
    // abstract class
    abstract void show();
}

public class InnerDemo {
    public static void main(String... args){
        // Non static inner class
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.msg();

        // static inner class
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.show();

        // Without Anonymous Class
        A a1  = new B();
        a1.show();

        // with Anonymous
        A a2 = new A(){
           @Override
           void show(){
               System.out.println("Hello From Anonymous");
           }
        };
        a2.show();

        // anonymous with abstract class
        C c1 = new C(){
            @Override
            void show(){
                System.out.println("anonymous with abstract class");
            }
        };
        c1.show();

    }
}
