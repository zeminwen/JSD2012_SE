package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历
 * Iterator iterator()
 * Collection提供了上述方法，可以获取一个用户遍历当前集合元素的迭代器，通过迭代器的操作
 * 来达到遍历集合元素的目的。
 *
 * java.util.Iterator接口，是迭代器接口，规定了遍历集合的相关操作。
 * 不同的集合都实现了一个可以遍历其元素的迭代器实现类，我们无需知道这些实现类的名字，只当
 * 它们是Iterator看待即可。
 * 迭代器遍历集合遵循的原则为:问，取，删。其中删除元素不是必须操作。
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        System.out.println(c);

        Iterator it=c.iterator();
        /*
          boolean hasNext()
          通过迭代器判断集合是否还有下一个元素可以获取(第一次判断是就是判断集合是否有
          第一个元素，以此类推。)
         */
        while(it.hasNext()){
            /*
              E next()
              通过迭代器获取下一个元素(第一次调用就是获取第一个元素)
              注意，调用next方法的前提应当是hasNext为true
             */
            String str=(String)it.next();
            System.out.println(str);
            //如果当前遍历出来的元素是"#"就将其删除
            if ("#".equals(str)){
                /*
                  迭代器遍历集合的过程中要求不能通过集合的方法增删元素，否则会在下次
                  调用next方法获取元素时抛出异常：
                  java.util.ConcurrentModificationException
                 */
//                c.remove(str);
                /*
                  void remove()
                  迭代器提供的remove方法是从集合中删除本次通过next方法获取的元素
                 */
                it.remove();
            }
        }
        System.out.println(c);
    }
}
