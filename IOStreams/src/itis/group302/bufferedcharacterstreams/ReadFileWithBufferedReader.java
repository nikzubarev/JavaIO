package itis.group302.bufferedcharacterstreams;

import java.io.*;

public class ReadFileWithBufferedReader {
    public static void main(String... args) {
        try {
            FileReader fr = new FileReader("C:\\dir\\SomeText.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}