package org.dsa.interface2;
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

    }
}
