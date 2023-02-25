package com.hspedu.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 11:53
 * @Version 1.0
 * 文件上传客户端
 */
public class UploadClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        String filePath = "D:\\Test\\Agony.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));

        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);


        byte[] buffer = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, readLen);
            bufferedOutputStream.flush();
        }
        socket.shutdownOutput();


        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();

        System.out.println("客户端结束....");

    }
}
