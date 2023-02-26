package com.hspedu.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/26 10:22
 * @Version 1.0
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(InetAddress.getByName("10.51.8.30"), 9999);

        // 发送文件名
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("la");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        // 接受文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        // 保存文件
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\Test\\music3.mp3"));
        bufferedOutputStream.write(bytes);
        // 保存到本地不用 shutdownOutput() 客户端服务端通信的时候才要设置结束标志
        // socket.shutdownOutput();

        // 关闭资源
        bufferedInputStream.close();
        bufferedOutputStream.close();
        bufferedWriter.close();
        socket.close();


    }
}
