package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK5之后推出了一个特性：增强型for循环，也称为新循环
 * 新循环不取代传统for循环的工作，它只是用来让我们用相同的语法去遍历集合或数组使用
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[]arr={"one","two","three","four","five"};
        for (int i=0;i<arr.length;i++){
            String str=arr[i];
            System.out.println(str);
        }
        //新循环在编译器编译后就改为了普通的for循环
        for (String str:arr){
            System.out.println(str);
        }

        Collection<String>c=new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        /*
          新循环遍历集合会被编译器改回成迭代器。因此注意，不要在遍历的过程中通过集合的方法
          增删元素。
         */
        for (String str:c){
            System.out.println(str);
        }
    }
}
