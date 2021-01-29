package homework.day04;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 用户登录功能
 * 程序启动后，要求用户输入用户名和密码
 * 然后去user.dat文件中比对
 * 成功则输出:登录成功
 * 失败则输出:登录失败，用户名或密码不正确
 * 
 * 登录失败的条件:用户名输入正确但是密码不正确，或者用户名
 * 输入不正确(user.dat文件中没有此人)
 * 
 * @author Xiloer
 *
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        RandomAccessFile raf = new RandomAccessFile(
                "user.dat","r");
        boolean login = false;//表示登录是否成功
        for(int i=0;i<raf.length()/100;i++){
            raf.seek(i*100);
            byte[] data = new byte[32];
            raf.read(data);
            String name = new String(data,"UTF-8").trim();
            if(name.equals(username)){
                //读取密码
               raf.read(data);
               String pwd = new String(data,"UTF-8").trim();
               if(pwd.equals(password)){
                   //登录成功
                   login = true;
               }
               break;//只要找到该用户，就停止循环
            }
        }
        if(login){
            System.out.println("登录成功!");
        }else{
            System.out.println("登录失败!");
        }
        raf.close();
    }
}
