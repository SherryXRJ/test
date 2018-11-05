package edu.sherry.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Sherry
 * @date 2018/11/5
 * @since
 */
public class ChannelDemo {

    public static void main(String[] args) throws IOException {
        transferFrom();
    }

    private static void transfer() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(ChannelDemo.class.getResource("/file/test.txt").getFile()));
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = new FileOutputStream("C:\\Users\\Sherry\\Desktop\\copy.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        outChannel.close();
        inChannel.close();
    }

    private static void transferFrom() throws IOException {
        FileChannel inChannel = new FileInputStream(new File(ChannelDemo.class.getResource("/file/test.txt").getFile())).getChannel();
        FileChannel outChannel = new FileOutputStream("C:\\Users\\Sherry\\Desktop\\copy.txt").getChannel();
        long size = inChannel.size();
        System.out.println("size = " + size);
        outChannel.transferFrom(inChannel, 0, size);
    }
}
