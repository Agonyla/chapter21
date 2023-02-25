package com.hspedu.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 11:18
 * @Version 1.0
 * 客户端 字符流
 */
public class SocketTCP03Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server 字符流");
        // // 插入换行表示写入内容结束 要求对方使用readLine()
        // bufferedWriter.newLine();
        /*
        当使用newLine设置结束时 只能读取一行
        读取的时候不能用while循环
        不用 newLine 直接用 socket.shutdownOutput();
         */
        // 使用字符流，需要手动刷新！！！
        bufferedWriter.flush();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readData = "";
        while ((readData = bufferedReader.readLine()) != null) {
            System.out.println(readData);
        }
        // readData = bufferedReader.readLine();
        // System.out.println(readData);

        socket.close();
        bufferedReader.close();
        bufferedWriter.close();


        System.out.println("客户端结束...");

    }
}
