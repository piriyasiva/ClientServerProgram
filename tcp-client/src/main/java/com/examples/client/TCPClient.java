package com.examples.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    private static int portNumber = 9000;
    private static String host = "localhost";
    private static Socket connection;

    public static void main(String[] args) throws IOException {
        connection = new Socket(host, portNumber);

        DataInputStream Stream1 = new DataInputStream(connection.getInputStream());
        DataOutputStream Stream2 = new DataOutputStream(connection.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number of your choice: ");
        Stream2.writeInt(scanner.nextInt());
        System.out.println(Stream1.readInt() * 2);
        Stream2.writeInt(scanner.nextInt());
        System.out.println("Server Response: " + Stream1.readInt());
    }
}
