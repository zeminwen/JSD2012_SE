package raf;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile src=new RandomAccessFile("bg.png","r");
        RandomAccessFile desc=new RandomAccessFile("bg_cp.png","rw");
        int d;
        while((d=src.read())!=-1){
            desc.write(d);
        }
        System.out.println("复制完毕");
        src.close();
        desc.close();
    }
}



