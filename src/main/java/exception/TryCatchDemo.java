package exception;

/**
 * 异常处理机制中的try-catch
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了...");
        try{//try语句块用来括上可能出错的代码片段
//            String str=null;   按“ctrl+/ ”快捷单行注释
//            String str="";
            String str="abc";
            /*

             */
            System.out.println(str.length());
            System.out.println(str.charAt(0));
            //try语句块中报错代码以下内容都不会被执行！
            System.out.println("!!!!!!!");
        //catch用来捕获try中出现的指定异常并予以解决
        }catch (NullPointerException a){
            System.out.println("出现空指针！");
        //catch可以定义多个，当try中不同异常有不同处理方式时可以分别捕获
        }catch (StringIndexOutOfBoundsException a){
            System.out.println("字符串下标越界了！");
        /*
        catch超类异常的意义：
        当try中某几类异常希望使用相同处理方法时，可以catch这些
        异常的超类。
        在最后一个catch处捕获Exception也可以避免因为一个未处理
        的异常导致程序中断。

        当多个catch的异常之间存在继承关系时，子类型异常一定要放在
        父类上面先行捕获......
         */
        }catch (Exception a){
            System.out.println("反正就是出错了");
        }
        System.out.println("程序结束了。。");
    }
}
