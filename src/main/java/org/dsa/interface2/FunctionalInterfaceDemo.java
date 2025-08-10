package org.dsa.interface2;

@FunctionalInterface
interface Calculator{
     int add(int a , int b);
}
public class FunctionalInterfaceDemo {
  public static void main(String[] args){
       // Anonymous inner class
       Calculator calculator = new Calculator(){
            @Override
            public int add(int a, int b) {
                 return  a+b;
            }
       };
       int sum = calculator.add(5,6);
       System.out.println(sum);
  }
}
