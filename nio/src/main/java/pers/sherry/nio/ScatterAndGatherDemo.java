package pers.sherry.nio;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterAndGatherDemo {

    public static void main(String[] args) throws IOException {
        scatterAndGather();
    }

    /**
     * 分散读取
     */
    private static void scatterAndGather() throws IOException {
        FileChannel inChannel = new FileInputStream(ScatterAndGatherDemo.class.getResource("/file/test.txt").getFile()).getChannel();
        ByteBuffer buffer1 = ByteBuffer.allocate(1);
        ByteBuffer buffer2 = ByteBuffer.allocate(100);
        inChannel.read(new ByteBuffer[]{buffer1, buffer2});
        //  buffer读状态
        buffer1.flip();
        buffer2.flip();

        FileChannel outChannel = new RandomAccessFile("C:\\Users\\Sherry\\Desktop\\ScatterAndGather.txt", "rw").getChannel();
        outChannel.write(new ByteBuffer[]{buffer2, buffer2});

    }
}
