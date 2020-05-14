package com.github.jayuc.daily.study.day20200413;

import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.io.IoUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 余杰 on 2020/4/13 11:27
 */

public class ServerDemo {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(45782);

//            while (true){
                Socket accept = serverSocket.accept();
                System.out.println(accept);

                ObjectOutputStream output = new ObjectOutputStream(accept.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(accept.getInputStream());

                String receiveStr = input.readUTF();
                System.out.println("<=============== " + receiveStr);

                output.writeUTF("Received: " + receiveStr);
                output.flush();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

}
