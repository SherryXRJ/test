package edu.sherry.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class BlockClientDemo {

    public static void main(String[] args) throws IOException {
        SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 65530));
        FileChannel inChannel = new FileInputStream(BlockClientDemo.class.getResource("/file/test.txt").getFile()).getChannel();
        inChannel.transferTo(0, inChannel.size(), clientChannel);
        inChannel.close();
        clientChannel.close();
    }
}
