package homework.day11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 改错题
 * 
 * 程序需求:向一个List集合中添加10个数字1-10，并将它们
 * 遍历出来并输出到控制台。
 *
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList<>();
		for (int i=1;i<11;i++){
			list.add(i);
		}
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}





