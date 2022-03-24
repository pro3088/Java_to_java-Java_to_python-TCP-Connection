package java_to_java_TCP_connection;

import java.io.*;
import java.net.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);


            String text;

            do {
                text = reader.readLine();
                // Initializing a Dictionary
                Dictionary geek = new Hashtable();

                // put() method
                geek.put("love", "an intense feeling of deep affection.");
                geek.put("education", "the process of receiving or giving systematic instruction, especially at a school or university.");
                geek.put("health", "the state of being free from illness or injury.");
                geek.put("computer", "an electronic device for storing and processing data, typically in binary form, according to instructions given to it in a variable program.");

                writer.println("Server: " + geek.get(text));

            } while (!text.equals("bye"));

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}