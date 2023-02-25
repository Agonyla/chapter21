package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author Agony
 * @Create 2023/2/25 20:46
 * @Version 1.0
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);

        byte[] bytes = "hello 明天吃火锅".getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.51.8.30"), 9999);

        // System.out.println(InetAddress.getLocalHost());
        // System.out.println(InetAddress.getByName("10.51.8.30"));
        socket.send(packet);

        // 接受消息
        byte[] bytes1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes1, bytes.length);
        socket.receive(packet1);
        int length = packet1.getLength();
        byte[] data = packet1.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        // 关闭资源
        socket.close();
        System.out.println("B端退出.....");
    }
}
