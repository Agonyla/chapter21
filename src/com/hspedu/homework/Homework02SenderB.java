package com.hspedu.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @Author Agony
 * @Create 2023/2/25 22:55
 * @Version 1.0
 */
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题");
        String question = scanner.next();
        byte[] bytes = question.getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.51.8.30"), 8888);

        // System.out.println(InetAddress.getLocalHost());
        // System.out.println(InetAddress.getByName("10.51.8.30"));
        socket.send(packet);

        // 接受消息
        bytes = new byte[1024];
        packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        // 关闭资源
        socket.close();
        System.out.println("B端退出.....");
    }
}
