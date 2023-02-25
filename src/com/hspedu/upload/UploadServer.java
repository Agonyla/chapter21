package com.hspedu.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 11:53
 * @Version 1.0
 * 文件上传服务端
 */
public class UploadServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在 8888 端口监听，等待连接..");

        Socket socket = serverSocket.accept();

        System.out.println(socket.getClass());

        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src\\Agony.jpg"));

        // OutputStream outputStream = socket.getOutputStream();
        // BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        // bufferedWriter.write("收到图片...");
        // bufferedWriter.newLine();
        // bufferedWriter.flush();


        byte[] buffer = new byte[1024];
        int readLen = 0;

        while ((readLen = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, readLen);
            bufferedOutputStream.flush();
        }

        socket.shutdownOutput();
        System.out.println("图片写入完成....");


        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端结束....");


    }
}
