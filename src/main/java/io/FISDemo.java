package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用文件输入流读取文件数据
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("fos.txt");
        byte[]data =new byte[1000];
        int len=fis.read(data);
        System.out.println("实际读取了："+len+"个字节");
        /*
        将给定的字节数组从下表offset处的连续len个字节按照utf-8编码
        转换为字符串。
         */
        String line=new String(data,0,len,"utf-8").trim();//去除字符后面的空白
        System.out.println(line);
        System.out.println(line.length());
        fis.close();

    }
}
