package edu.sherry.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Sherry
 * @date 2018/11/5
 * @since
 */
public class ChannelDemo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        open();
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
        FileChannel outChannel = new FileOutputStream("C:\\Users\\Sherry\\Desktop\\transferFrom.txt").getChannel();
        long size = inChannel.size();
        System.out.println("size = " + size);
        outChannel.transferFrom(inChannel, 0, size);
    }

    /**
     * 通过open方法获取channel
     */
    private static void open() throws IOException, URISyntaxException {
        FileChannel inChannel = FileChannel.open(Paths.get(ChannelDemo.class.getResource("/file/test.txt").toURI()), StandardOpenOption.READ);
        System.out.println(inChannel);
    }
}
