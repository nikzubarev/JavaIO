package itis.group302.datastreams;

import java.io.*;

public class ReadWritePrimitiveData {
    public static void main(String... args) throws IOException {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new FileOutputStream(
                                new File("myData.data")));
                DataInputStream dis = new DataInputStream(
                        new FileInputStream("myData.data"));
        ) {
            dos.writeChars("OS");
            dos.writeInt(999);
            dos.writeDouble(45.8);
            dos.writeBoolean(true);
            dos.writeUTF("Will score 100%");
            System.out.println(dis.readChar());
            System.out.println(dis.readChar());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());

            System.out.println(dis.readUTF());
            //System.out.println(dis.readBoolean());
        }
    }
}