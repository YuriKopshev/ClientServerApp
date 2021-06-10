package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final static int port = 8181;



    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             InputStream from = clientSocket.getInputStream();
             OutputStream to = clientSocket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(from));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(to))) {
          while (true) {
              writer.write("Write your name..." + "\n");
              writer.flush();
              String name = reader.readLine();
              writer.write("  Are you child? (yes/no)" + "\n");
              writer.flush();


              String answer = reader.readLine();

              if (answer.equals("yes")) {
                  writer.write("Welcome to the kids area," + name + " Let's play!" + "\n" );
              } else {
                  writer.write("Welcome to the adult zone, " + name + " Have a good rest, or a good working day!" + "\n");
                  break;
              }
              writer.flush();


          }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
