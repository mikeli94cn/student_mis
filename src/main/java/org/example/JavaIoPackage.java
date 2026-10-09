package org.example;

import java.io.*;

/*
the java.io package provides java's foundational framework for reading and writing data.

it operates primarily on the concepts of Streams -- ordered sequenced of data moving from a source(input) to a
destination(output).

to master java i/o, you must understand its two distinct design pillars, Byte Streams (for raw binary data like images
or compiled files) and Character Streams (for human-readable text), along with Decorators that add buffering or structural
formatting to those streams.

here is an architectural introduction to the 10 core classes of java.io package.
 */

public class JavaIoPackage {
    public static void main(String[] args) {
        /*
        1. working with the File system: File

        */
        File file = new File("data.txt");
        if (file.exists()) {
            System.out.println("data exists");
            System.out.printf("file size:%d bytes\n", file.length());
        }

        /*
        2. Byte Streams: raw binary data
         */
        //low-level binary copy operation
        try (FileInputStream fis = new FileInputStream("input.jpg");
             FileOutputStream fos = new FileOutputStream("output.jpg")) {
            int bytes;
            while ((bytes = fis.read()) != -1) {
                fos.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        3. Character Streams: text data, FileWriter
         */
        String filePath = "charOutPut.txt";
        String content = "Hello\nWorld";
        //True in FileWriter(filePath, true) enables append mode instead of overwriting
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Successfully wrote to " + filePath);

        } catch (IOException e) {
            System.out.println("Error writing to " + filePath);
            System.err.println(e.getMessage());
            e.printStackTrace();

        }

        /*
        reuse File class
         */
        File fileChar = new File("CharOutPut.txt");
        if (fileChar.exists()) {
            System.out.println("CharOutPut exists");
            System.out.printf("file size:%d bytes\n", fileChar.length());
        }

        /*
        3. character streams: text data, FileReader
         */
        try (FileReader reader = new FileReader(filePath)) {
            int ch;
            System.out.println("Reading from file by character:\n---");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println("\n---");
        } catch (IOException e) {
            System.err.println("Error writing to " + filePath + ": " + e.getMessage());
        }

        /*
        3. character streams: reading into a character array with FileReader
        this demo reads chunks of characters into a pre-allocated char[] cbuf for better performance.
         */
        char[] cbuf = new char[1024];
        try (FileReader reader = new FileReader(filePath)) {
            int len = reader.read(cbuf);
            if (len != -1) {
                System.out.print(new String(cbuf, 0, len));
            }
        } catch (IOException e) {
            System.err.println("error reading from " + filePath + ": " + e.getMessage());
        }

        /*
        3. character streams: copying a file (combining FileReader and FileWriter)
         */
        String sourcePath = "file.txt";
        String sourceContent = "china india";
        try (FileWriter fw = new FileWriter(sourcePath)) {
            fw.write(sourceContent);
        } catch (IOException e) {
            System.err.println("error writing to " + sourcePath + ": " + e.getMessage());
        }


        // reuse File to read meta data of file
        File fileNew = new File(sourcePath);
        if (fileNew.exists()) {
            System.out.println("File " + sourcePath + " exists");
            System.out.printf("file size:%d bytes\n", fileNew.length());
        }

        String destPath = "copyFile.txt";
        try (FileReader reader = new FileReader(sourcePath);
             FileWriter writer = new FileWriter(destPath)) {
            int temp;
            while ((temp = reader.read()) != -1) {
                writer.write((char) temp);
            }
            System.out.println("File copied from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
