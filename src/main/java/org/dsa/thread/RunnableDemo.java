package org.dsa.thread;


// Creating thread using Runnable functional interface
// using lambda expression
public class RunnableDemo {
    public static void main(String... args){
        Runnable obj1 = ()->{
            for(int i=0;i<500;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hi , I am  Thread 1");
            }
        };

        Runnable obj2 = () ->{
            for(int i=0;i<500;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hi , I am  Thread 2");
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

    }
}
