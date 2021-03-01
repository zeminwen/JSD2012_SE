package com.webserver.http;

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

    public void flush(){

    }

    public void putHeaders(String name,String value){
        headers.put(name,value);
    }

    public void setEntity(File entity){
        this.entity=entity;
        String fileName=entity.getName();
        String ext=fileName.substring(fileName.lastIndexOf(".")+1);
        String type= HttpContext.getMimeType(ext);
        putHeaders("Content-Type",type);
        putHeaders("Content-Length",entity.length()+"");
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
}
