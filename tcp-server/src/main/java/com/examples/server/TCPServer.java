package com.examples.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPServer {
    public static int maxPoolSize = 10;
    public static int queueSize = 20;
    public static int startPoolSize = 5;
    static Socket clientSocket;
    static ServerSocket serverSocket;
    static ExecutorService executor;
    private static int portNumber = 9000;

    public static void main(String[] args) {

        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue(queueSize);
        executor = new ThreadPoolExecutor(startPoolSize, maxPoolSize, 100, TimeUnit.MILLISECONDS, queue);


        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Listening to: " + portNumber);


            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client gets Connected");
                executor.execute(new TCPThread(clientSocket));
            }

        } catch (IOException e) {
            System.out.println("Server processing Stopped");
            e.printStackTrace();
        }
    }

}

