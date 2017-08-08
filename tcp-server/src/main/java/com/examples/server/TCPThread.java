package com.examples.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPThread extends Thread {
    private Socket clientSocket;

    public TCPThread(Socket client) {
        this.clientSocket = client;
    }

    public void run() {
        try {
            DataInputStream Stream1 = new DataInputStream(this.clientSocket.getInputStream());
            DataOutputStream Stream2 = new DataOutputStream(this.clientSocket.getOutputStream());

            int number = Stream1.readInt();
            Stream2.writeInt(number);
            System.out.println("Client being Processed");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
