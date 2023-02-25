package com.hspedu.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author Agony
 * @Create 2023/2/25 14:50
 * @Version 1.0
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Test\\Agony.jpg"));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();

        // 接受从服务端接受的消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bis.close();
        bos.close();
        socket.close();
    }
}
