package io;

import java.io.*;

/**
 * 使用缓冲输出流写出数据的缓冲区问题
 */
public class BOS_flushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("bos.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        String line="让我再看你一遍，从南到北。";
        byte[]data =line.getBytes("utf-8");
        bos.write(data);
        /*
         void flush()
         将缓冲流中已经缓存的数据一次性写出
         频繁的调用flush会增加实际写出数据的次数，写出次数多则
         写出效率差，但是可以提高写出数据的即时性。
         */
        bos.flush();
        System.out.println("写出完成");
        /*
        缓冲流的close方法中会执行一次flush
         */
        bos.close();
    }
}
