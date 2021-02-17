package homework.day09;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server{
    private ServerSocket serverSocket;
    private List<PrintWriter> allOut= Collections.synchronizedList(new ArrayList<>());

    public Server(){
        try {
            System.out.println("正在启动服务器");
            serverSocket=new ServerSocket(8088);
            System.out.println("启动服务器完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try{
            while (true) {
            System.out.println("等待客户端连接");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了");
            Runnable handler = new ClientHandler(socket);
            Thread t = new Thread(handler);
            t.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }

    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;
        public ClientHandler(Socket socket){
            this.socket=socket;
            host=socket.getInetAddress().getHostAddress();
        }
        @Override
        public void run() {
            PrintWriter pw=null;
            try {
                BufferedReader br=new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(),"utf-8"
                        )
                );
                pw=new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(),"utf-8"
                                )
                        ),true
                );
                allOut.add(pw);
                System.out.println(host+"上线了，当前在线人数:"+allOut.size());
                String line;
                while ((line=br.readLine())!=null){
                    String message=line;
                    System.out.println(host+"说:"+line);
                    allOut.forEach(o->o.println(host+"说:"+message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                allOut.remove(pw);
                System.out.println("下线了，当前在线人数:"+allOut.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}