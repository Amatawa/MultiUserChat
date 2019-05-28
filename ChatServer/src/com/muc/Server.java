package com.muc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Server starts the local server
 */
public class Server extends Thread{
    private final int serverPort;

    /**
     * instantiates workerList, which is the list of people on server
     */
    private ArrayList<ServerWorker> workerList = new ArrayList<>();

    public Server(int serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * pretty self explanatory
     * @return
     */
    public List<ServerWorker> getWorkerList() {
        return workerList;
    }

    @Override
    /**
     * Starts the server sockets itself
     */
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while (true) {
                System.out.println("About to accept client connections...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                ServerWorker worker = new ServerWorker(this, clientSocket);
                workerList.add(worker);
                worker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Self Explanatory
     * @param serverWorker
     */
    public void removeWorker(ServerWorker serverWorker) {
        workerList.remove(serverWorker);
    }
}
