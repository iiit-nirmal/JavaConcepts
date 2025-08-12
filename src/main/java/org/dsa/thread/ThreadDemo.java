package org.dsa.thread;

class Hi extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("I am class Hi");
        }
    }
}

class Hello extends Thread {
    @Override
    public void run() {
        //sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i =0;i<1000;i++){
            System.out.println("I am class Hello");
        }
    }
}

public class ThreadDemo {
    public static void main(String... args){
        Hi hi = new Hi();
        Hello hello = new Hello();
        // order of execution of threads is not guaranteed
        // thread priority
        hi.setPriority(Thread.MIN_PRIORITY);
        System.out.println("hi thread : "+hi.getPriority());
        hello.setPriority(10);
        //or use predefined constant
        hello.setPriority(Thread.MAX_PRIORITY);
        System.out.println("hello thread : "+hello.getPriority());


        hi.start();
        hello.start();


    }
}
