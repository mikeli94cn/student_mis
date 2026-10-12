package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ReadWriteFile {
    public static void main(String[] args) {

        String fromFile = "input.txt";
        String toFile = "output.txt";
        try (
                BufferedReader br = new BufferedReader(new FileReader(fromFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(toFile));
        ) {

            /*
            // method 1 : use read(), inefficient
            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(ch);
            }
             */

            // method 2 : jdk10+ , highly-optimized
            br.transferTo(bw);

            /*
            // method 3 : jdk8 or older , efficient and without extra blank line at last
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (!isFirstLine) {
                    bw.newLine();
                }
                bw.write(line);
                isFirstLine = false;
            }
             */


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // method 4, using java NIO
        Path from = Paths.get(fromFile);
        Path to = Paths.get(toFile);
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
