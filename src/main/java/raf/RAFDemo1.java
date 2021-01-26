package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *RAF是专门用来读写文件的类。其基于指针对文件进行随机读写
 */
public class RAFDemo1 {
    public static void main(String[] args) throws IOException {
        //想对当前目录下的raf.dat文件进行操作
        /*
        RAF常用构造器
        RandomAccessFile(File,file,String mode)
        RandomAccessFile(String path,String mode)
        第一个参数为要进行读写的文件，可以传入file对象也可以
        直接给定该文件的路径。
        第二个参数为操作模式，有两种：
        “r”：只读模式
        “rw”：读写模式
         */
        RandomAccessFile raf=new RandomAccessFile(
                "./raf.dat","rw"
        );

        //向文件中写入一个字节的2进制数据
        /*

         */
        raf.write(1);
        raf.write(2);
        System.out.println("写出完毕！");
        /*
        raf.dat文件数据内容：
        00000001    00000010
         */
        raf.close();//最终要调用close方法！！
    }
}
