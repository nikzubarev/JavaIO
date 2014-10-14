package itis.group302.readerandwriter;

import java.io.*;

public class ReadChars {
    public static void main(String[] args) throws IOException {
        try (
                FileReader input = new FileReader("C:\\dir\\SomeText.txt");
                FileWriter output = new FileWriter("C:\\dir\\SomeTextCopy.txt");
        ) {
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
        }
    }
}
