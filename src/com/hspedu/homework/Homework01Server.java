package com.hspedu.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 22:36
 * @Version 1.0
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        String answer = "";
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        if ("name".equalsIgnoreCase(s)) {
            // System.out.println("我是龚铖龙");
            answer = "我是龚铖龙";

        } else if ("hobby".equalsIgnoreCase(s)) {
            // System.out.println("编写java程序");
            answer = "编写java程序";
        } else {
            // System.out.println("你说啥呢");
            answer = "你说啥呢";
        }

        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();


        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
