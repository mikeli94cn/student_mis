package org.example;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadAndWriteDataFromConsole {
    public static void main(String[] args) {
        /*
        System.in
        System.out
        System.err
        Scanner
        Console
         */
        InputStream in = System.in;
        int res = 0;
        try {
            res = in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Input data: %c\n", res);
        System.err.println("error occur");
        //must run in system terminal, run in ide will quit directly
        Console c=System.console();
        if (c==null) {
            System.err.println("No console available");
            return;

        }
        String email=c.readLine("Enter your email: ");
        char[] password=c.readPassword("Enter your password: ");
        Arrays.fill(password, ' ');

    }
}
