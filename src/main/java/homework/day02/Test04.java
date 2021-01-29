package homework.day02;
/**
 * 执行程序，分析并解决问题
 * 
 * NumberFormatException出现的情况通常是由包装类将字符串解析为基本类型时,由于字符串内容不能正确描述基本类型导致该异常.
 * 数字    格式      异常
 * 
 * 
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		/*
		 * 原因:字符串中出现了空格
		 */
//		String num = "123 ";
		String num = "123";
		int d = Integer.parseInt(num);
		System.out.println(d);
		
		/*
		 * 原因:描述小数的字符串是不能用Integer解析为整数的
		 */
//		num = "123.456";
		num = "123";
		d = Integer.parseInt(num);
		System.out.println(num);
		
		/*
		 * 原因:出现了语法不允许的字符"；"
		 */
		num = "123";
//		d = Integer.parseInt(num)；
		d = Integer.parseInt(num);
		System.out.println(d);
	}
}
