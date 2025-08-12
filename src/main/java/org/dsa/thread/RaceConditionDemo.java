package org.dsa.thread;



class Counter{
    int count=0;
    // use synchronized keyword for consistent result
    public  void increase(){
        count++;
    }

}

public class RaceConditionDemo {
    public static void main(String... args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable obj1 = () ->{
            for(int i =0 ; i<1000;i++){
                counter.increase();
            }
        };
        Runnable obj2 = () ->{
            for(int i =0 ; i<1000;i++){
                counter.increase();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.count);

    }
}
