package org.dsa.abstraction;

abstract class Animal
{
 abstract void makeSound();
}

// can't implement, will have to declare as abstract
abstract class WildAnimal extends Animal{
}

// Concret Classes
class Jiraafe extends WildAnimal{
    @Override
    void makeSound(){
        System.out.println("Fewww Fewww");
    }
}

class Horse extends WildAnimal{
    @Override
    void makeSound(){
        System.out.println("Hieee Hieee");
    }
}
public class AbstractionDemo {
    public static void main(String... args){

        // Abstraction
        Animal horse = new Horse();
        horse.makeSound();
    }
}
