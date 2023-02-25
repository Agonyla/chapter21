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
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {

        // 创建一个 DatagramSocket 对象, 准备在9999接受数据
        DatagramSocket socket = new DatagramSocket(9999);

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

        // 发送消息
        byte[] bytes = "好的, 明天见!".getBytes();
        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.51.8.30"), 9998);
        socket.send(packet1);

        // 关闭资源
        socket.close();
        System.out.println("A端退出....");

    }
}
