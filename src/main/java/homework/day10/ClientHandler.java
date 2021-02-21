package homework.day10;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            HttpRequest request = new HttpRequest(socket);
            HttpResponse response = new HttpResponse(socket);
            String path = request.getUri();
            File file = new File("webapps" + path);
            if (file.exists() && file.isFile()) {
                System.out.println("该资源已找到:" + file.getName());
                Map<String, String> mimeMapping = new HashMap<>();
                mimeMapping.put("html", "text/html");
                mimeMapping.put("css", "text/css");
                mimeMapping.put("js", "application/javascript");
                mimeMapping.put("png", "image/png");
                mimeMapping.put("gif", "image/png");
                mimeMapping.put("jpg", "image/jpeg");
                String fileName = file.getName();
                String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
                String type = mimeMapping.get(ext);
                System.out.println(ext);
                response.putHeader("Content-Type", type);
                response.putHeader("Content-Length", file.length() + "");
                response.setEntity(file);
            } else {
                System.out.println("该资源不存在");
                File notFoundPage = new File("webapps/root/404.html");
                response.setStatusCode(404);
                response.setStatusReason("NotFound");
                response.putHeader("Content-Type", "text/html");
                response.putHeader("Content-Length", notFoundPage.length() + "");
                response.setEntity(notFoundPage);
            }
            response.putHeader("Server", "WebServer");
            response.flush();
            System.out.println("响应发送完毕");
        }catch (EmptyRequestException e){

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
