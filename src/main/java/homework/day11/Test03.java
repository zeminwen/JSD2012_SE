package homework.day11;

import java.util.*;

/**
 * 生成10个0-100之间的不重复的随机数,并输出
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> set = new HashSet<>();
		while(set.size()<10){
			set.add(random.nextInt(100));
		}
		System.out.println(set.size());
		System.out.println(set);
	}
}
