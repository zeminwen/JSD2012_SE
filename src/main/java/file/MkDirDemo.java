package file;

import java.io.File;

/**
 * 使用File创建一个目录
 */
public class MkDirDemo {
    public static void main(String[] args) {
        //在当前目录下新建一个目录demo
        File dir =new File("demo");
        if (dir.exists()) {
            System.out.println("该目录已存在！");
        }else{
            dir.mkdir();
            System.out.println("文件已创建");
        }
    }
}
