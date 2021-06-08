package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("127.0.0.1", Server.port);
             InputStream from = clientSocket.getInputStream();
             OutputStream to = clientSocket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(from));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(to))) {
            System.out.println("New connection accepted");
            writer.write("Yuri Kopshev");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

