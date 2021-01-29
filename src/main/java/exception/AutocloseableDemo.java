package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后，Java推出了一个新的特性：自动关闭
 */
public class AutocloseableDemo {
    public static void main(String[] args) {
        //
        try(
                /*

                 */
                FileOutputStream fos=new FileOutputStream("fos.dat");
                ){
            fos.write(1);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
