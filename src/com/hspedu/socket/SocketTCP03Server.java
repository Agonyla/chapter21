package com.hspedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 11:11
 * @Version 1.0
 * 服务端 字符流
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String readData = "";

        while ((readData = bufferedReader.readLine()) != null) {
            System.out.println(readData);
        }
        // readData = bufferedReader.readLine();
        // System.out.println(readData);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write("hello, client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.write("lalala1");
        bufferedWriter.newLine();
        bufferedWriter.write("lalala2");
        bufferedWriter.newLine();
        bufferedWriter.write("lalala3");
        // // 插入换行表示写入内容结束
        // bufferedWriter.newLine();
        // 使用字符流，需要手动刷新！！！
        bufferedWriter.flush();
        socket.shutdownOutput();


        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();

        System.out.println("服务端结束...");
    }
}
