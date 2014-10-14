package itis.group302.objectstreams;

import java.io.*;

class WriteObject {

    public static void main(String args[]) throws IOException,
            ClassNotFoundException {
        try (
                FileOutputStream out = new FileOutputStream("object.data");
                ObjectOutputStream oos = new ObjectOutputStream(out);
                FileInputStream in = new FileInputStream("object.data");
                ObjectInputStream ois = new ObjectInputStream(in);
        ) {
            Car c = new Car("Jetta");
            oos.writeObject("The name of a car is: ");
            oos.writeObject(c);
            oos.flush();

            System.out.print(ois.readObject());
            c = (Car) ois.readObject();
            System.out.println(c.name);
        }
    }
}

class Car implements Serializable {
    String name;

    Car(String value) {
        name = value;
    }
}
