import java.net.*;
import java.io.*;

class LabTwelveClient {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 555);
            DataInputStream incoming = new DataInputStream(s.getInputStream());

            String str = incoming.readUTF();
            System.out.println(str);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}