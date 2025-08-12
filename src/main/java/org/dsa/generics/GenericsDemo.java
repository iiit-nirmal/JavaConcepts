package org.dsa.generics;

import java.util.*;

class Box {
    private Object value;

    public void set(Object value) {
        this.value = value;
    }

    public Object get() {
        return value;
    }
}

// Generic Class
class BoxGeneric<T>{
    private T value;
    public void set(T val){
        this.value=val;
    }
    public T get(){return value;}
}

// Generic Method
class Utils{
    // using gene
   public static <T> void printArray(List<T> array){
      for(T item:array){
          System.out.println(item+" ");
      }
   }

   // upper bound
    public  static <T extends Number> double sum(T a , T b){
       return a.doubleValue()+b.doubleValue();
    }
}



public class GenericsDemo {
    public static void main(String... args) {
        Box box = new Box();
        box.set("Hello");
        box.set(1);
        // class cast exception
       // String val = (String) box.get();


        BoxGeneric<Integer> boxGeneric = new BoxGeneric();
        boxGeneric.set(1);
        System.out.println(boxGeneric.get());

        BoxGeneric<String> boxGeneric2 = new BoxGeneric();
        boxGeneric2.set("Hello");
        System.out.println(boxGeneric2.get());

        // Generic Methos
        Utils.printArray(Arrays.asList(1,2,3));
        Utils.printArray(Arrays.asList("Hi","Bye","Lie"));

        //upper bound
        System.out.println(Utils.sum(5, 10));      // Integer
        System.out.println(Utils.sum(5.5, 4.5));  // Double
    }
}
