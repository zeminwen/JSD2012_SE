package homework.day10;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String uri;
    private String protocol;
    private Map<String,String>headers=new HashMap<>();
    private Socket socket;
    private String requestURI;
    private String queryString;
    private Map<String ,String >parameter=new HashMap<>();

    public HttpRequest(Socket socket) throws EmptyRequestException {
        this.socket=socket;
        parseRequestLine();
        parseHeaders();
        parseContent();
    }

    private void parseUri(){
        if (uri.contains("?")){
            String[]data=uri.split("\\?");
            requestURI=data[0];
            if (data.length>1){
                queryString=data[1];
                data=queryString.split("&");
                for (String para:data){
                    String[]paras=para.split("=");
                    if (paras.length>1){
                        parameter.put(paras[0],paras[1]);
                    }else {
                        parameter.put(paras[0],null);
                    }
                }
            }
        }else{
            requestURI=uri;
        }
        System.out.println("requestURI:"+requestURI);
        System.out.println("queryString:"+queryString);
        System.out.println("parameter:"+parameter);
    }
    private void parseRequestLine() throws EmptyRequestException {
        System.out.println("HttpRequest:开始解析请求行");
        try {
            String line=readLine();
            if (line.isEmpty()){
                throw new EmptyRequestException();
            }
            System.out.println("请求行:"+line);
            String[] data=line.split("\\s");
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
        System.out.println("HttpRequest:请求行解析完成");
    }
    private void parseHeaders(){
        System.out.println("HttpRequest:开始解析消息头");
        try {
            while (true){
            String line=readLine();
            if (line.isEmpty()){
                break;
            }
            System.out.println("消息头:"+line);
            String[]data=line.split("\\s");
            headers.put(data[0],data[1]);
            }
            System.out.println("headers:"+headers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HttpRequest:请求行解析完成");
    }
    private void parseContent(){
        System.out.println("HttpRequest:开始解析消息正文");

        System.out.println("HttpRequest:消息正文解析完成");
    }
    public String readLine() throws IOException {
        InputStream in=socket.getInputStream();
        StringBuilder builder=new StringBuilder();
        char pre=' ';
        char cur=' ';
        int d;
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

    public String getHeaders(String name) {
        return headers.get(name);
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
}
