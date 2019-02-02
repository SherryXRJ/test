package pers.sherry.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockClientDemo {

    public static void main(String[] args) throws IOException {
        SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 65530));
        //  非阻塞模式
        clientChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("zxcvb".getBytes());
        buffer.flip();
        clientChannel.write(buffer);
        clientChannel.close();
    }

}
