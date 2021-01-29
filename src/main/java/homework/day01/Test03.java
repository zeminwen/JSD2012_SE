package homework.day01;
/**
 * 修改下面代码的错误
 * 
 * 下面代码完成的功能是输出字符串中的每一个字符
 * 
 * @author Xiloer
 *
 */
public class Test03 {
    //缺少main方法
    public static void main(String[] args) {
        //string的类名不对，S要大写
//        string str = "hello world! i love java!";
        String str = "hello world! i love java!";
        //length对于String而言是方法，不是属性.
        //for循环体位置不对，要将下面的两句代码包含在循环中
        //循环条件不能是i<=str.length(),否则下面的charAt会越界
//        for(int i = 0;i<=str.length;i++) {}
        for(int i = 0;i<str.length();i++) {
            //charAt是字符串的方法!
//            char c = i.charAt(i);
            char c = str.charAt(i);
            //输出应当使用out,而不应该使用err
//            System.err.println(c);
              System.out.println(c);
        }
    }
}






