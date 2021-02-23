package homework.day10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private int statusCode=200;
    private String statusReason="OK";
    private Map<String,String>headers=new HashMap<>();
    private File entity;
    private Socket socket;
    public HttpResponse(Socket socket){
        this.socket=socket;
    }

    public void flush(){
        sendResponseLine();
        sendHeaders();
        sendContent();
    }
    private void sendResponseLine(){
        System.out.println("HttpResponse:开始发送状态行");
        String line="HTTP1.1"+" "+statusCode+" "+statusReason;
        try {
            println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HttpResponse:状态行发送完毕");
    }
    private void sendHeaders(){
        System.out.println("HttpResponse:开始发送响应头");
        try {
            headers.forEach((k,v)->{
                try {
                    String line=k+": "+v;
                    System.out.println("响应头:"+line);
                    println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            println("");//单独发送CRLF表示响应头部分发送完毕!
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HttpResponse:响应头发送完毕");
    }
    private void sendContent(){
        System.out.println("HttpResponse:开始发送响应正文");
        try (
                FileInputStream fis=new FileInputStream(entity);
                ){
            OutputStream out=socket.getOutputStream();
            int len;
            byte[]buf=new byte[1024*10];
            while ((len=fis.read(buf))!=-1){
                out.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HttpResponse:响应正文发送完毕");
    }
    public void println(String line) throws IOException {
        OutputStream out=socket.getOutputStream();
        byte[]data=line.getBytes("iso8859-1");
        out.write(data);
        out.write(13);
        out.write(10);
    }

    public void putHeader(String name,String value){
        headers.put(name,value);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public File getEntity() {
        return entity;
    }

    public void setEntity(File entity) {
        this.entity = entity;
        String fileName = entity.getName();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        String type = HttpContext.getMimeType(ext);
        System.out.println(ext);
        putHeader("Content-Type", type);
        putHeader("Content-Length", entity.length() + "");
    }
}
