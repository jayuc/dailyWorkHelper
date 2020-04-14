package com.github.jayuc.daily.study;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by 余杰 on 2020/4/13 11:35
 */

public class ClientDemo {

    public static void main(String[] args) {

        ObjectInputStream input;
        ObjectOutputStream output;

        try {
            InetAddress inetAddress = InetAddress.getByName(null);

            Socket socket = new Socket(inetAddress, 45782);

            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());

            output.writeUTF("Hi");
            output.flush();

            System.out.println(input.readUTF());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
