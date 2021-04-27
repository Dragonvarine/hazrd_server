/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverThread implements Runnable
{

    //Socket server input
    ServerSocket serverSocket;
    Socket socket;
    ObjectInputStream objectInputStream;

    //Stored object for input
    static ArrayList<String> messages;

    serverThread()
    {
        socket = new Socket();
        messages = new ArrayList<>();
    }

    @Override
    public void run()
    {
        try
        {
            serverSocket = new ServerSocket(44334);
        } catch (IOException e)
        {
        }

        while (true)
        {
            try
            {
                while (true)
                {
                    socket = serverSocket.accept();
                    objectInputStream = new ObjectInputStream(socket.getInputStream());
                    messages.add((String) objectInputStream.readObject());
                    System.out.println(messages.size());
                }
            } catch (IOException e)
            {
            } catch (ClassNotFoundException e)
            {
            }
        }
    }
}
