package itis.group302.bytestreams;

import java.io.*;

public class ReadWriteBytesUsingFiles {
    public static void main(String[] args) throws IOException {
        try (
                InputStream in = new FileInputStream("c:\\dir\\book.pdf");
                OutputStream out = new FileOutputStream("c:\\dir\\book2.pdf");
        ) {
            int data;
            byte[] byteArr = new byte[1024];
            while ((data = in.read(byteArr)) != -1) {
                out.write(byteArr, 0, data);
            }
            System.out.println("File successfully copied");
        }
    }
}
