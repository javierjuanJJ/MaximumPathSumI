package org.example;

import org.example.MaximumPathSumI.MaximumPathSumI;

import java.io.File;
import java.io.FileFilter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {

            File[] files = new File(".").listFiles(pathname -> pathname.isFile());

            for (int counter = 0; counter < files.length; counter++) {
                System.out.println(MaximumPathSumI.maximumPathSumI(files[counter]));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}