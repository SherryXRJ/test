package edu.sherry.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeSinkDemo {

    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        //  写管道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        new Thread(() -> {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                buffer.put("abc".getBytes());
                try {
                    buffer.flip();
                    sinkChannel.write(buffer);
                    buffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //  读管道
        Pipe.SourceChannel sourceChannel = pipe.source();
        new Thread(() -> {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                try {
                    int length = sourceChannel.read(buffer);
                    if (length > 0) {
                        System.out.println(new String(buffer.array()));
                        buffer.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
