package com.hb0730.boot.admin.token.impl;

import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

public class RedisTokenServiceImplTest {

    @Test
    public void getLoginUserTest() {
    }

    @Test

    public void testSocketChannelConcurrent() throws Exception {
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        //服务器端IP地址
        String serverIP = "10.0.0.201";
        //服务器端端口号
        int port = 1710;
        //发送内容
        String data[] ={"First","Second","Third"};
        try {
            //建立连接
            socket = new Socket(serverIP,port);
            //初始化流
            os = socket.getOutputStream();
            is = socket.getInputStream();
            byte[] b = new byte[1024];
            for(int i = 0;i < data.length;i++){
                //发送数据
                os.write(data[i].getBytes());
                //接收数据
                int n = is.read(b);
                //输出反馈数据
                System.out.println("服务器反馈：" + new String(b,0,n));
            }
        } catch (Exception e) {
            e.printStackTrace(); //打印异常信息
        }finally{
            try {
                //关闭流和连接
                is.close();
                os.close();
                socket.close();
            } catch (Exception e2) {}
        }
    }
}
