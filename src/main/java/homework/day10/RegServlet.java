package homework.day10;

public class RegServlet {
    public void server(HttpRequest request,HttpResponse response){
        System.out.println("RegServlet:开始处理用户注册...");
        String username=request.getParameter("username");

    }
}
