package org.example;

import java.io.File;

public class JavaIoPackage {
    public static void main(String[] args) {
        File file =new File("data.txt");
        if(file.exists()){
            System.out.println("data exists");
            System.out.printf("file size:%d bytes\n",file.length());
        }
    }
}
