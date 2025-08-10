package org.dsa.interface2;

import java.io.*;

// Deep copy using Cloneable and Object's clone
class Address implements Cloneable{

    String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Address clone(){
        try {
            return (Address) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }

    public Address(String city) {
        this.city = city;
    }
}


class Employee implements  Cloneable{
    private String name;
    private int age;
    private  Address address;

    public Employee(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Deep copy
    @Override
    public Employee clone(){
        try {
            Employee e2 = (Employee) super.clone();
            e2.setAddress(this.address.clone());
            return e2;
        }
        catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}


/**
 *  if we do not implement Serializable , then it throws : java.io.NotSerializableException
 *
 */
class Person implements Serializable, Cloneable {
  private static final long serialVersionUID=1L;

  private String name;
  private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
     *  Cloneable Interface
     *  it works with Object's clone method
     * if we dont override clone method , then it throws CloneNotSupportedException
     * by Object's clone perform shallow copy
     * */

    @Override
    public Person clone(){
        try{
            return (Person) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}




public class MarkerInterfaceDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p1 = new Person("Nirmal", 33);

        // Serializing
        try(ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(p1);
            System.out.println("Serializing "+p1.getName());
        }

        //De -Serializing
        try(ObjectInputStream in = new ObjectInputStream( new FileInputStream("person.ser"))){
            Person p2 = (Person) in.readObject();
            System.out.println("De Serializing "+p2.getName());
        }

        // Cloning --> Shallow copy
        Person p3 = new Person("Kamesh",34);
        Person p4 = p3.clone();
        System.out.println(p4.getName()+" , "+p4.getAge());

        // Cloning --> Deep Copy
        Address a1 = new Address("Bengal");
        Employee e1= new Employee("Kamal",35,a1);
        Employee e2 = e1.clone();
        System.out.println("e1: "+e1.getName()+", "+e1.getAge()+", "+e1.getAddress());
        System.out.println("e2: "+e2.getName()+", "+e2.getAge()+", "+e2.getAddress());
    }

}
