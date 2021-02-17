package homework.day09;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    private Socket socket;
    public Client(){
        try {
            System.out.println("正在连接服务端");
            socket=new Socket("localhost",8088);
            System.out.println("连接服务端完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        ServerHandler handler=new ServerHandler();
        Thread t=new Thread(handler);
        t.setDaemon(true);
        t.start();
        try (
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
            while (true){
                String line=scanner.nextLine();
                if ("exit".equals(line)){
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client=new Client();
        client.start();
    }
    private class ServerHandler implements Runnable{
        @Override
        public void run() {
            try (
                    BufferedReader br=new BufferedReader(
                       new InputStreamReader(
                            socket.getInputStream(),"utf-8"
                       )
                    );
            ){
              String line;
              while ((line=br.readLine())!=null){
                  System.out.println(line);
              }
            } catch (IOException e) {
            }
        }
    }
}