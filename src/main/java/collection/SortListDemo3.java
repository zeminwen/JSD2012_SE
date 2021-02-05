package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序字符串
 */
public class SortListDemo3 {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("ada");
        list.add("tom");
        list.add("jerry");
        list.add("rose");
        list.add("jack");
        list.add("MIKE");
        list.add("KOBE");
        list.add("JAMES");
        list.add("hanmeimei");
        System.out.println(list);
//        Collections.sort(list);
        //按照字符多少排序
        Collections.sort(list, (s1,s2)->s1.length()-s2.length());

        System.out.println(list);

    }
}
