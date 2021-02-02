package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室客户端
 */
public class Client {
    private Socket socket;
    /**
     * 构造方法，用来初始化客户端
     */
    public Client(){
        try {
            /*
            Java.net.Socket 套接字
            Socket封装了TCP协议的通讯细节，使用它可以和远端计算机
            建立连接，并通过它获取一个输入流和输出流，使用这两个流
            的读写数据完成与远端计算机的交互。

            实例化Socket时需要传入两个参数：
            1.服务端的地址信息(IP地址)
            通过地址可以找到网络上服务端的计算
            2.服务端打开的服务窗口
            通过这个端口可以找到服务端计算机运行的服务端程序
             */
            System.out.println("正在连接服务端...");
            //localhost表示本机IP
            //实例化的过程就是连接的过程，若连接服务器失败会抛出异常
            socket=new Socket("localhost",8088);
            System.out.println("与服务端建立连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 客户端开始工作的方法
     */
    public void start(){

        try (
            /*
            Socket提供的方法
            OutputStream getOutputStream()
            该方法会返回一个字节输出流，通过这个输出流写出的字节会通过网络
            发送给远端计算机
             */
//            OutputStream out = socket.getOutputStream();
//            OutputStreamWriter osw=new OutputStreamWriter(out,"utf-8");
//            BufferedWriter bw=new BufferedWriter(osw);
//            PrintWriter pw=new PrintWriter(bw,true);
            PrintWriter pw=new PrintWriter(
               new BufferedWriter(
                   new OutputStreamWriter(
                       socket.getOutputStream(),"utf-8"
                   )
               ),true
            );

        ){
            Scanner scanner=new Scanner(System.in);
            System.out.println("请开始输入内容，单独输入exit退出");
            while (true) {
                String line=scanner.nextLine();
                if ("exit".equals(line)) {
                    break;
                }
                pw.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                //最终不再通讯时要关闭socket(相当于挂电话)
                //socket关闭后，通过socket获取的输入流与输出流就自动关闭了
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client =new Client();
        client.start();
    }
}










