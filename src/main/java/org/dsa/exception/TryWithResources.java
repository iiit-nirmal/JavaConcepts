package org.dsa.exception;

import java.io.*;

public class TryWithResources {
    public static void main(String... args) throws IOException {

        // automatic closer of resources using try-with-resource
        // so , no need of finally
        // no need of catch as we are ducking the exception
        //Resources are closed in reverse order of creation.
        try(
                FileReader fr = new FileReader("src/resource/input.txt");
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter("src/resource/output.txt");
                BufferedWriter bw  = new BufferedWriter(fw);
        )
        {
            String line;
            while ((line= br.readLine()) != null){
                bw.write(line.toUpperCase());
                bw.newLine(); // moves to new line
            }
        }
    }

}
