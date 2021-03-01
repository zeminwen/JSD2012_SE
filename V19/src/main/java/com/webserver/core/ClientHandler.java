package com.webserver.core;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.servlet.HttpServlet;

import java.io.File;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        HttpRequest request=new HttpRequest(socket);
        HttpResponse response=new HttpResponse(socket);
        String path=request.getRequestURI();
        HttpServlet servlet=ServerContext.getServlet(path);
        if (servlet!=null){
            servlet.service(request,response);
        }else {
            File file=new File("webapps"+path);
            if (file.exists()&&file.isFile()){
                System.out.println("该资源已找到:"+file.getName());
                response.setEntity(file);
            }else {
                System.out.println("该资源不存在");
                File notFoundPage=new File("webapps/root/404.html");
                response.setStatusCode(404);
                response.setStatusReason("NotFound");
                response.setEntity(notFoundPage);
            }
        }
        response.putHeaders("Server","WebServer");


    }
}
