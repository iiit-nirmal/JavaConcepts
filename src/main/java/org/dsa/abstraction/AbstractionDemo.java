package org.dsa.abstraction;

abstract class Animal
{
   // instance variable
    String name;
    static boolean canThink;

    //param Constructor
    Animal(String name){
        this.name=name;
    }

 abstract void makeSound();
}

// can't implement, will have to declare as abstract
abstract class WildAnimal extends Animal{
    WildAnimal(String name){
        super(name);
    }
}

// Concret Classes
class Jiraafe extends WildAnimal{
    Jiraafe(String name){
        super(name);
    }
    @Override
    void makeSound(){
        System.out.println("Fewww Fewww");
    }
}

class Horse extends WildAnimal{

    Horse(String name){
        super(name);
    }
    @Override
    void makeSound(){
        System.out.println("Hieee Hieee");
    }
}
public class AbstractionDemo {
    public static void main(String... args){

        // Abstraction
        Animal horse = new Horse("Woky");
        horse.makeSound();
    }
}
