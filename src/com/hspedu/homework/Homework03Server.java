package com.hspedu.homework;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/26 10:22
 * @Version 1.0
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {

        // 监听端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听，等待连接..");
        Socket socket = serverSocket.accept();

        // 接受文件名
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        String answer = "";
        if ("高山流水".equals(s)) {
            // answer = "收到" + s;
            answer = "D:\\Test\\music\\高山流水.mp3";
        } else {
            answer = "D:\\Test\\music\\无名.mp3";
        }
        // System.out.println(answer);

        // 读取本地文件文件
        byte[] bytes = StreamUtils.streamToByteArray(new FileInputStream(answer));

        // 传输文件
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();

        // 关闭资源
        bufferedOutputStream.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();

    }
}
