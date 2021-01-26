package file;

import javax.print.DocFlavor;
import java.io.File;

/**
 * Java,io,File可以表示硬盘上的一个文件或目录
 * 使用File可以：
 * 1.访问该文件或目录的属性信息（大小、修改日期。可读可写等）
 * 2.创建或删除文件和目录
 * 3.访问一个目录中所有子项
 * 但是File不能访问文件中的数据
 */
public class FileDemo {
    public static void main(String[] args) {
        /*
        File创建时可以指定路径
        该路径通常使用相对路径，有更好的跨平台性。
        相对路径中“./”表示当前目录，当前目录在哪里视当前程序
        运行环境决定。在idea或eclipse里运行时当前目录就是这个程序
        所在的项目目录。
         */
        File file=new File("./demo.txt");//alt+回车 自动导包
        String name=file.getName();
        System.out.println(name);
        long len=file.length();
        System.out.println(len+"字节");

        boolean cr=file.canRead();
        System.out.println("可读："+cr);
        boolean cw=file.canWrite();
        System.out.println("可写："+cw);
        boolean ih=file.isHidden();
        System.out.println("是否隐藏："+ih);
    }
}
