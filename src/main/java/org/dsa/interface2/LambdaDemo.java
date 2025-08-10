package org.dsa.interface2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

interface SampleA {
    void show();
}
interface SampleWithParam{
    void show(int i);
}
interface SampleWithParams{
    void show(int i,int j);
}
interface SampleWithReturn{
    int add(int i,int j);
}

class MethodRef{
   static int staticAdd(int i, int j){
       return i+j;
   }

    int add(int i, int j){
        return i+j;
    }

    void show(String s){
        System.out.println("greet "+s);
    }
}

class Department{
    int deptid;
    String deptName;

    public Department(int deptid, String deptName) {
        this.deptid = deptid;
        this.deptName = deptName;
    }
}

public class LambdaDemo {
    public static void main(String... args){
        // No brackets , No param
        SampleA a = ()-> System.out.println("Hello");
        a.show();

        // Note :
        //With one parameter, parentheses are optional
        // , and the type can be omitted.
        // lambda with param , no brackets required
        SampleWithParam b = (i)-> System.out.println("Hello "+i);
        b.show(4);

        //lamba with two params
        SampleWithParams c = (i,j)-> System.out.println(i+j);
        c.show(5,6);

        // lambda with return
        // if there is only one line then no paranthesizes
        // needed
        //If the body is a single expression, omit return
        SampleWithReturn d = (i,j) -> i+j;
        System.out.println(d.add(5,7));
        // ------------------------------------------------

        // Method Reference vs lambda
        // static method
        BiFunction<Integer,Integer,Integer>
                lamdbaAdd = (x,y)->MethodRef.staticAdd(x,y);
        System.out.println("lamdbaAdd: "+lamdbaAdd.apply(1,2));

        BiFunction<Integer,Integer,Integer> refAdd= MethodRef :: staticAdd;
        System.out.println("refAdd: "+refAdd.apply(1,2));

        //Reference to an Instance Method of a Particular Object
        MethodRef methodRef = new MethodRef();
        Consumer<String> lamdbaConsumer = (x)-> methodRef.show(x);
        lamdbaConsumer.accept("Nirmal");
        Consumer<String> refConsumer =  methodRef::show;
        refConsumer.accept("Nirmal");

        //Reference to an Instance Method of an Arbitrary Object of a Particular Type
        List<String> names = Arrays.asList("Nirmal", "Aman", "Raj");
        names.sort((x,y)-> x.compareToIgnoreCase(y));
        System.out.println("sorted using lambda: "+names);
        names.sort(String::compareToIgnoreCase);
        System.out.println("sorted using method reference: "+names);

        // Constructor Reference
        BiFunction<Integer,String,Department> lamdaConstruct=
                (Integer x,String y)-> new Department(x,y);

        BiFunction<Integer,String,Department> refConstruct= Department::new;
        Department dept = refConstruct.apply(1,"IT");
        System.out.println(dept.deptid);
    }
}
