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
}
