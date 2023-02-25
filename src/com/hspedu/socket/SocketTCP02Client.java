package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 10:05
 * @Version 1.0
 * 客户端 字节流
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {

        // 连接本机的 9999 端口 如果连接成功则返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket = " + socket.getClass());


        // 连接上后, 生成Socket, 通过socket.getOutputStream()
        // 得到 和 socket对象关联的输出流对象

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, server".getBytes());
        // 发送完之后需设置一个结束标记！！！
        // 也可以使用 writer.newLine()
        // 要求对方用 readLine() 方法读取
        // writer是一个Writer对象
        socket.shutdownOutput();


        // 获取socket相关联的输入流
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }


        // 关闭流对象和socket，必须关闭
        socket.close();
        outputStream.close();

        inputStream.close();
        System.out.println("客户端退出...");
    }
}
