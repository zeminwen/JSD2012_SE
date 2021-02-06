package homework.day11;

import java.util.*;

/**
 * 生成10个0-100的随机数并存入一个List集合中并输出
 * 之后将集合元素翻转:第一个在最后一个，最后一个在第一个。
 * 以此类推，并输出
 * 
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) {
        List list=new ArrayList();
        Random random=new Random();
        for (int i=0;i<10;i++){
            int num=random.nextInt(101);
            list.add(num);
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

}