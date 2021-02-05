package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈结构
 * 栈可以保存一组元素，但是存取元素必须遵循先进后出原则。
 * 使用栈通常用来完成如后退、前进这样的功能使用。
 *
 * Deque双端队列如果只调用从同一侧做出入队操作时，就形成了栈结构，因此双端队列也为
 * 栈结构提供了经典的两个方法：入栈push，出栈pop
 */
public class StackDemo {
    public static void main(String[] args) {
        Deque<String>stack=new LinkedList<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        System.out.println(stack);

        String str=stack.pop();
        System.out.println(str);
        System.out.println(stack);

        //使用新循环遍历
        for (String s:stack){
            System.out.println(s);
        }
        //使用pop方法遍历
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
