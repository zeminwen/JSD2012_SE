package homework.day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * 生成10个0-100之间的不重复的随机数,并输出
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Collection<Integer> c=new ArrayList();
		Random random=new Random();
		for (int i=0;i<10;i++){
			int num=random.nextInt(101);
			c.add(num);
		}
		for (Integer a:c){
			System.out.println(a);
		}
	}
}
