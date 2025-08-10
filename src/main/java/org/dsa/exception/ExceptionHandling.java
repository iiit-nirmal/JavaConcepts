package org.dsa.exception;

import java.util.Scanner;

class MyException extends Exception{
    public MyException(String msg){
        super(msg);
    }
}

public class ExceptionHandling {
    public static void main(String... args) throws MyException {
        // Arithmetic Exception
        try {
            int result = 10 / 0;
        }
        catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("Error Cause: "+
                    e.getCause() + " ,message: " + e.getMessage()) ;
        }
        System.out.println("Program Continues 1" );

        // Multiple Catch --> write in more specific to generic ones
        String str = null;
        try {
            System.out.println(str.length());
        }
        catch (NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
        }
        System.out.println("Program Continues 2");

        // explicit throw
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 0)
            throw new MyException("Wrong input");

        System.out.println("Program Continues 3");

    }
}
