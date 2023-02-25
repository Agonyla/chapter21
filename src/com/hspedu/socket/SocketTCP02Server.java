package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 10:05
 * @Version 1.0
 * 服务端 字节流
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {

        // 在 9999 端口监听, 等待连接
        // ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的 并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听，等待连接..");


        // 当没有客户端连接9999端口时，程序会阻塞
        // 有客户端连接时,则会返回socket对象
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());


        // 通过socket.getInputStream() 读取数据
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readDate = 0;
        while ((readDate = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readDate));
        }

        // 获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, client".getBytes());
        socket.shutdownOutput();

        // 关闭流和socket
        inputStream.close();
        serverSocket.close();
        socket.close();

        outputStream.close();

        System.out.println("服务端退出...");
    }

}
