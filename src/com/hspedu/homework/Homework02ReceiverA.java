package com.hspedu.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author Agony
 * @Create 2023/2/25 22:55
 * @Version 1.0
 */
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        // 创建一个 DatagramSocket 对象, 准备在8888接受数据
        DatagramSocket socket = new DatagramSocket(8888);

        // 构建一个 DatagramPacket 对象, 准备接受数据
        // UDP 一个数据包最大为 64K 下面可以直接设置成 64 * 1024
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // 调用 接受方法, 将通过网络传输的 DatagramPacket 对象填充到 packet
        System.out.println("接受端A 等待接受数据....");
        socket.receive(packet);

        // 把 datagramPacket 进行拆包, 取出数据, 并显示
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        String answer = "";
        if ("四大名著是哪些".equals(s)) {
            answer = "四大名著《红楼梦》《三国演义》《西游记》《水浒传》";
        } else {
            answer = "what?";
        }

        // 发送消息
        byte[] bytes = answer.getBytes();
        packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.51.8.30"), 9998);
        socket.send(packet);

        // 关闭资源
        socket.close();
        System.out.println("A端退出....");
    }
}
