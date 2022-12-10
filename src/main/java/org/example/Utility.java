package org.example;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Map;

public class Utility {

    public Client addNewClient(int port, int n, LocalTime timeStart, Socket socket) {
        return new Client(uniqueName(n), port, timeStart, socket);
    }

    public String uniqueName(int n) {
        String name = "client-" + n;
        return name;
    }

    public void messageAll(String message, Map<Client, PrintWriter> cliens, String name) {
        cliens.forEach((k, v) -> {
            v.println(name + ": " + message);
            v.flush();
        });
    }

    public void writeToFile(File file, String word, String name) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(name + ": " + word + " " + LocalTime.now() );
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("The file has not created");
        }
    }


//    public Client getClientFromMap(Map<Client, PrintWriter> cliens, PrintWriter value) {
//        for (Client client : cliens.keySet())  {
//            if (cliens.get(client).equals(value))
//                return client;
//            }
//        return null;
//        }
}







