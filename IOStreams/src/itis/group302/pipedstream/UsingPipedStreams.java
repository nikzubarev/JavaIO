package itis.group302.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class UsingPipedStreams {
    public static void main(String... args) {
        try (
                PipedInputStream pipeIn = new PipedInputStream();
                PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);
        ) {
            int countRead = 0;
            byte[] toRead = new byte[100];

            // Считывать в массив, пока он полностью не будет заполнен
            while (countRead < toRead.length) {

                // Записать в поток некоторое количество байт
                for (int i = 0; i < (Math.random() * 10); i++) {
                    pipeOut.write((byte) (Math.random() * 127));
                }

                // Считать из потока доступные данные,
                // добавить их к уже считанным.
                int willRead = pipeIn.available();

                //Нужно считать только до предела массива
                if (willRead + countRead > toRead.length)
                    willRead = toRead.length - countRead;

                countRead += pipeIn.read(toRead, countRead, willRead);
            }
        } catch (IOException e) {
            System.out.println("Impossible IOException occur: ");
            e.printStackTrace();
        }
    }
}

