package com.hspedu.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Agony
 * @Create 2023/2/24 22:47
 * @Version 1.0
 * 演示InetAddress类的使用
 */
public class API01 {
    public static void main(String[] args) throws UnknownHostException {

        // 获取本机的 InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        System.out.println("===================");

        // 根据主机名获取 InetAddress 对象
        InetAddress agony = InetAddress.getByName("Agony");
        System.out.println(agony);

        System.out.println("====================");

        // 根据域名获取 InetAddress 对象
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

        System.out.println("=====================");

        // 通过 InetAddress 对象,获取对应地址
        String hostAddress = byName.getHostAddress();
        System.out.println(hostAddress);

        System.out.println("=====================");
        
        // 通过 InetAddress 对象,获取主机名
        String hostName = byName.getHostName();
        System.out.println(hostName);
    }
}
