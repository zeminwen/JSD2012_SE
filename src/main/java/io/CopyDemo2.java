package io;

import java.io.*;

/**
 * 使用缓冲流完成文件复制
 *
 * 缓冲流：java.io.BufferedInputStream和BufferedOutputStream
 * 它们是一对高级流，在流连接中的作用是提高读写效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("fos.txt");
        BufferedInputStream bis=new BufferedInputStream(fis);
        FileOutputStream fos=new FileOutputStream("fos_cp.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        int d;
        long start=System.currentTimeMillis();
        /*
        缓冲流内部维护着一个字节数组，默认为8k，无论我们读写时用哪种方式，
        最终都会被缓冲流转化为块读写8k进行来保证读写效率
         */
        while((d=bis.read())!=-1){
            bos.write(d);
        }
        long end=System.currentTimeMillis();
        System.out.println("复制完成!耗时："+(end-start)+"ms");
        bis.close();
        bos.close();

    }
}
