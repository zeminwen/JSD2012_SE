package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public abstract class HttpServlet {
    public void service(HttpRequest request, HttpResponse response){
        String method=request.getMethod();
        if ("GET".equalsIgnoreCase(method)){
            doGet(request,response);
        }else if ("POST".equalsIgnoreCase(method)){
            doPost(request,response);
        }
    }

    public abstract void doGet(HttpRequest request,HttpResponse response);

    public abstract void doPost(HttpRequest request,HttpResponse response);
}
