package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 集合转换为数组
 * Collection提供了一个方法toArray,可以将一个集合转换为一个数组
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);

        String[] array=c.toArray(new String[c.size()]);
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
    }
}
