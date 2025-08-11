package org.dsa.inputs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String... args) throws IOException {
        System.out.println("Hello");
        // -------------------------------------------
        // reads one char at a time and returns ASCII value
        int input1 = System.in.read(); // read 1st char
        int input2 = System.in.read(); // read 2nd char
        // to get same value as input integer , use input-48
        System.out.println((char)(input1) +","+ (char)(input2));

        // flushing leftover
        System.in.read();

        // -------------------------------------------
        // to read multiple characters or entire line of input , use BufferedReader
        // read complete line and return as String
        System.out.println("enter a number");
        InputStreamReader in  = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int num = Integer.parseInt(reader.readLine());
        System.out.println(num);
        reader.close();

        // -------------------------------------------
        // reading suing Scanner
        //simpler and offers convenient methods to parse primitive
        //types --> nextInt , nextFloat, nextDouble
        Scanner sc = new Scanner(System.in);
        int num2 = sc.nextInt();
        System.out.println(num2);
        sc.close();



    }
}
