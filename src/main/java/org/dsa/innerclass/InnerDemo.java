package org.dsa.innerclass;
import java.util.Map;


class Outer{
    int deptId;
    static String maxHours;

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

public class InnerDemo {
    public static void main(String... args){
        // Non static inner class
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.msg();

        // static inner class
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.show();
    }
}
