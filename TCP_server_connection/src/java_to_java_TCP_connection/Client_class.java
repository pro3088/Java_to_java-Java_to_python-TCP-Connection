package java_to_java_TCP_connection;

import java.net.*;
import java.io.*;

public class Client_class {
        public static void main(String[] args) {
//            if (args.length < 2) return;

            String hostname = "localhost";
            int port = 9046;

            try (Socket socket = new Socket(hostname, port)) {

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));

                String text;

                do {

                    text = reader.readLine();

                    writer.println(text);

                    InputStream input = socket.getInputStream();

                    BufferedReader read2 = new BufferedReader(new InputStreamReader(input));

                    String time = read2.readLine();

                    System.out.println(time);

                } while (!text.equals("bye"));

                socket.close();

            } catch (UnknownHostException ex) {

                System.out.println("Server not found: " + ex.getMessage());

            } catch (IOException ex) {

                System.out.println("I/O error: " + ex.getMessage());
            }
        }
}
