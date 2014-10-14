package itis.group302.bufferedstreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class NonBufferedBytesReadWrite {
    public static void main(String[] args) throws IOException {
        try (
                InputStream in = new FileInputStream("c:\\dir\\book.pdf");
                FileOutputStream out = new FileOutputStream("c:\\dir\\book2.pdf");
        ) {
            Date start = new java.util.Date();
            System.out.println("FileI/O started : " + start);
            int data;
            byte[] byteArr = new byte[1024];
            while ((data = in.read(byteArr)) != -1) {
                out.write(byteArr, 0, data);
            }
            Date end = new java.util.Date();
            System.out.println("FileI/O completed : " + end);
            System.out.println("MilliSeconds elapsed : " +
                    (end.getTime() - start.getTime()));
        }
    }
}