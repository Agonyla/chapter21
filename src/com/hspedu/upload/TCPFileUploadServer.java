package com.hspedu.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 14:50
 * @Version 1.0
 */
public class TCPFileUploadServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务端在 8888 端口监听，等待连接....");

        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\Agony2.jpg"));
        bos.write(bytes);

        // 向客户端回复“收到图片”
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();
        socket.shutdownOutput();

        bis.close();
        bos.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();


    }
}
