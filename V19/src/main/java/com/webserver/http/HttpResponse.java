package com.webserver.http;

import javax.xml.ws.spi.http.HttpContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private int statusCode=200;
    private String statusReason="OK";
    private Map<String,String>headers=new HashMap<>();
    private File entity;
    private ByteArrayOutputStream baos=new ByteArrayOutputStream();
    private PrintWriter writer=new PrintWriter(baos);
    private Socket socket;
    public HttpResponse(Socket socket){
        this.socket=socket;
    }

    public void setEntity(File entity){
        this.entity=entity;
        String fileName=entity.getName();
        String ext=fileName.substring(fileName.lastIndexOf(".")+1);
        //String type= HttpContext
    }
}
