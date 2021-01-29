package homework.day05;

import io.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 将当前目录下的所有obj文件获取到，并进行
 * 反序列化后输出每个用户的信息(直接输出反序
 * 列化后的User对象即可)
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis= new FileInputStream("person.obj");;
        ObjectInputStream ois=new ObjectInputStream(fis);
        Person p=(Person)ois.readObject();
        System.out.println(p);
        ois.close();
    }




}
