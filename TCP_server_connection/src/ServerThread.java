import java.io.*;
import java.net.Socket;
import java.util.Dictionary;
import java.util.Hashtable;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            String fromClient;
            String toClient;

            do {

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

                fromClient = in.readLine();
                System.out.println("received: " + fromClient);

                // Initializing a Dictionary
                Dictionary geek = new Hashtable();

                // put() method
                geek.put("love", "an intense feeling of deep affection.");
                geek.put("education", "the process of receiving or giving systematic instruction, especially at a school or university.");
                geek.put("health", "the state of being free from illness or injury.");
                geek.put("computer", "an electronic device for storing and processing data, typically in binary form, according to instructions given to it in a variable program.");

                out.println("Server: " + geek.get(fromClient));

            } while (!fromClient.equals("bye"));

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}