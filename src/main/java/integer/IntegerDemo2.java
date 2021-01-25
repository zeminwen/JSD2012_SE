package integer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*
包装类常见功能
 */
public class IntegerDemo2 {
    public static void main(String[] args) {
        //获取int最大值
        int imax=Integer.MAX_VALUE;
        System.out.println(imax);
        int imin=Integer.MIN_VALUE;
        System.out.println(imin);

        long lmax=Long.MAX_VALUE;
        long lmin=Long.MIN_VALUE;
        System.out.println("lmax:"+lmin);

        /*
        包装类提供了一个静态方法parseXXX(String line)
        可以将字符串解析为对应的基本数据类型，前提是该字符串
        正确描述了基本类型可以保存的值。否则会抛出异常：
        java.lang.NumberFormatException
         */
        String line="123";
        int in=Integer.parseInt(line);
        System.out.println(in);//123
        double dou=Double.parseDouble(line);
        System.out.println(dou);//123.0
    }
}
