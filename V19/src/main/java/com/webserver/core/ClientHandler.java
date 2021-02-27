package com.webserver.core;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

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
        String path=reques
    }
}
