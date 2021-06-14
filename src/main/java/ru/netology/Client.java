package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("netology.homework", Server.PORT);
             InputStream from = clientSocket.getInputStream();
             OutputStream to = clientSocket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(from));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(to))) {
            while (true) {
                String question;
                question = reader.readLine();
                System.out.println("server talk: " + question + "\n");

                writer.write("Yuri" + "\n");
                writer.flush();
                writer.write("no" + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

