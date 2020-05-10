import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class LabTwelveServer {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(555);
            Socket s = ss.accept();
            DataOutputStream outgoing = new DataOutputStream(s.getOutputStream());

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            outgoing.writeUTF(formatter.format(date));
            outgoing.flush();
            outgoing.close();
            s.close();

            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}