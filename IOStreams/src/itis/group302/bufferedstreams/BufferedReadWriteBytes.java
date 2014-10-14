package itis.group302.bufferedstreams;

import java.io.*;
import java.util.Date;

public class BufferedReadWriteBytes {
    public static void main(String[] args) throws IOException {
        try (
                InputStream in = new FileInputStream("c:\\dir\\book.pdf");
                OutputStream out = new FileOutputStream("c:\\dir\\book2.pdf");
                InputStream bis = new BufferedInputStream(in);
                OutputStream bos = new BufferedOutputStream(out);
        ) {
            Date start = new java.util.Date();
            System.out.println("FileI/O started : " + start);
            int data;
            byte[] byteArr = new byte[1024];
            while ((data = bis.read(byteArr)) != -1) {
                bos.write(byteArr, 0, data);
            }
            Date end = new java.util.Date();
            System.out.println("FileI/O completed : " + end);
            System.out.println("MilliSeconds elapsed : " +
                    (end.getTime() - start.getTime()));
        }
    }
}