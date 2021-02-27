package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String uri;
    private String protocol;
    private String requestURI;
    private String queryString;
    private Map<String,String>parameter=new HashMap<>();
    private Map<String,String>headers=new HashMap<>();
    private Socket socket;

    public HttpRequest(Socket socket){
        this.socket=socket;



    }
    private void parseRequestLine() throws EmptyRequestException {
        System.out.println("HttpRequest:开始解析请求行");
        try {
            String line=readLine();
            if (line.isEmpty()){
                throw new EmptyRequestException();
            }
            System.out.println("请求行:"+line);
            String[]data=line.split("\\s");
            method=data[0];
            uri=data[1];
            protocol=data[2];
            parseUri();
            System.out.println("method:"+method);
            System.out.println("uri:"+uri);
            System.out.println("protocol:"+protocol);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HttpRequest:请求行解析完毕");
    }

    private void parseUri(){
        try {
            uri= URLDecoder.decode(uri,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (uri.contains("?")){
            String[]data=uri.split("\\?");
            requestURI=data[0];
            if (data.length>1){
                queryString=data[1];
                parseParameter(queryString);
            }
        }else {
            requestURI=uri;
        }
        System.out.println("requestURI:"+requestURI);
        System.out.println("queryString:"+queryString);
        System.out.println("parameter:"+parameter);
    }

    private void parseParameter(String line){
        String[]data=line.split("&");
        for (String para:data){
            String[]paras=para.split("=");
            if (paras.length>1){
                parameter.put(paras[0],paras[1]);
            }else {
                parameter.put(paras[0],null);
            }
        }
    }

    private void parseHeaders(){
        System.out.println("HttpRequest:开始解析消息头...");
        try {
            while (true){
                String line=readLine();
                if (line.isEmpty()){
                    break;
                }
                System.out.println("消息头:"+line);
                String[]data=line.split(":\\s");
                headers.put(data[0],data[1]);
            }
            System.out.println("headers:"+headers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HttpRequest:消息头解析完成");
    }

    private void parseContent(){
        System.out.println("HttpRequest:开始解析消息正文...");
        if ("post".equalsIgnoreCase(method)){
            String len=headers.get("Content-Length");
            if (len!=null){
                int length=Integer.parseInt(len);
                byte[]data=new byte[length];
                try {
                    InputStream in=socket.getInputStream();
                    in.read(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String type=headers.get("Content-Type");
                if (type!=null){
                    if ("application/x-www-form-urlencoded".equalsIgnoreCase(type)) {
                        String line = null;
                        try {
                            line = new String(data, "iso8859-1");
                            line = URLDecoder.decode(line, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        System.out.println("消息正文:" + line);
                        parseParameter(line);
                    }
                }
            }
        }
        System.out.println("HttpRequest:消息正文解析完毕");
    }







    public String readLine() throws IOException {
        InputStream in=socket.getInputStream();
        int d;
        char cur='a';
        char pre='a';
        StringBuilder builder=new StringBuilder();
        while ((d=in.read())!=-1){
            cur=(char)d;
            if (pre==13&&cur==10){
                break;
            }
            builder.append(cur);
            pre=cur;
        }
        return builder.toString().trim();
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getParameter(String name) {
        return parameter.get(name);
    }

    public String getHeaders(String name) {
        return headers.get(name);
    }
}
