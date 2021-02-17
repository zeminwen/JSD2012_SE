package homework.day10;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            InputStream in=socket.getInputStream();
            String line=readLine();
            System.out.println("请求行:"+line);
            String method;
            String uri;
            String protocol;
            String[]data=line.split("\\s");
            method=data[0];
            uri=data[1];
            protocol=data[2];
            System.out.println("method:"+method);
            System.out.println("uri:"+uri);
            System.out.println("protocol:"+protocol);
            while(true){
                line=readLine();
                if (line.isEmpty()){
                   break;
                }
                System.out.println("消息头:"+line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String readLine() throws IOException {
        InputStream in=socket.getInputStream();
        int d;
        char pre=' ';
        char cur=' ';
        StringBuilder builder=new StringBuilder();
        while((d=in.read())!=-1){
            cur=(char)d;
            if (pre==13&&cur==10){
               break;
            }
            builder.append(cur);
            pre=cur;
        }
        return builder.toString().trim();
    }
}
