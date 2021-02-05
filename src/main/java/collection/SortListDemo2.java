package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list=new ArrayList<>();
        list.add(new Point(1,2));
        list.add(new Point(9,9));
        list.add(new Point(8,6));
        list.add(new Point(18,22));
        list.add(new Point(35,1));
        list.add(new Point(5,4));
        System.out.println(list);
        /*
          该sort方法在排序时要求集合元素必须实现了Comparable接口，否则编译不通过。
          当我们使用某个API的方法时，其要求我们为之改动其他地方的代码才可以使用时，
          这种情况就具有了侵入性，这不利于程序的后期维护。
         */
//        Collections.sort(list);
        //下面写法就解决了侵入性问题
        Collections.sort(list, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                int olen1=o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int olen2=o2.getX()*o2.getX()+o2.getY()*o2.getY();
                return olen1-olen2;
            }
        });


        System.out.println(list);
    }
}
