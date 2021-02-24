package homework.day10;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RegServlet {
    public void server(HttpRequest request,HttpResponse response){
        System.out.println("RegServlet:开始处理用户注册...");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String nickname=request.getParameter("nickname");
        String ageStr=request.getParameter("age");
        if (username==null||password==null||nickname==null||!ageStr.matches("[0-9]+")){
            File file=new File("webapps/myweb/reg_info_error.html");
            response.setEntity(file);
            return;
        }
        int age=Integer.parseInt(ageStr);
        System.out.println(username+","+password+","+nickname+","+age);
        try(
                RandomAccessFile raf=new RandomAccessFile("user.dat","rw");
        ){
            for (int i=0;i<raf.length()/100;i++){
                raf.seek(i*100);
                byte[]data=new byte[32];
                raf.read(data);
                String name=new String(data,"utf-8").trim();
                if (username.equals(name)){
                    File file=new File("webapps/myweb/have_user.html");
                    response.setEntity(file);
                    return;
                }
            }
            byte[]data=username.getBytes("utf-8");
            data= Arrays.copyOf(data,32);
            raf.write(data);
            data=password.getBytes("utf-8");
            data=Arrays.copyOf(data,32);
            raf.write(data);
            data=nickname.getBytes("utf-8");
            data=Arrays.copyOf(data,32);
            raf.write(data);
            raf.writeInt(age);
            System.out.println("注册成功");
            File file=new File("webapps/myweb/reg_success.html");
            response.setEntity(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("用户注册处理完毕！");
    }
}
