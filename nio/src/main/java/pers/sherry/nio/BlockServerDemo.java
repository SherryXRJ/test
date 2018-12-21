package pers.sherry.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(65530));
        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\Sherry\\Desktop\\ServerSocket.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        SocketChannel socketChannel = serverChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.close();
        outChannel.close();
        serverChannel.close();
    }
}
