package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前目录下新建一个文件test.txt
        File file=new File("./test.txt");
        /*
        boolean exist()
        判断当前File表示的文件或目录是否已存在，存在则返回true
         */
        if (file.exists()) {
            System.out.println("该文件已存在！");
        }else{
            //将File表示的文件创建出来
            file.createNewFile();
            System.out.println("文件已创建！");
        }
    }
}
