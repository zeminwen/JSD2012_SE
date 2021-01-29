package homework.day02;

import java.util.Scanner;

/**
 * 程序需求:
 * 程序启动后，实例化一个Person，然后要求用户输入用户名
 * 和年龄.并加以验证:
 * 名字至少一个字符，否则输出:姓名不能为空!
 * 年龄必须是0-100之间的数字，否则输出:年龄不合法!
 * 
 * 都输入正确时最后输出该用户信息
 * 
 * 将下面写好的代码解除注释改正里面的错误使得程序可以正常
 * 运行。
 * 异常记一记:
 * 下面会出现的每一种异常先翻译异常的名字，然后解决该异常后
 * 思考是什么原因引起的错误并在注释中标注出来
 *
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) {
		Person p = new Person();
		//1:Scanner没有导包
		//2:Scnner类名没有拼写正确
		//3:system的第一个S要大写
//		Scanner scanner = new Scnner(system.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名:");
		String name = scanner.nextLine();
		/*
			空指针异常原因:
			当我们调用某个对象的属性或方法时，如果此对象是null时
			就会引发空指针异常
			分析:p.getName().length()
			出现空指针的原因可能是:
			p.getName():这里若空指针，则说明p是null
			p.getName().length():若空指针，说明getName方法返回值为null
		 */
		//分析得出:p.getName()返回值为null。
		//解决:逻辑错误，判定的应当是用户输入的名字
//		if(p.getName().length()==0) {
		if(name.trim().length()==0) {
			System.out.println("姓名不能为空!");
		}else{
			p.setName(name);
			System.out.println("请输入年龄:");
			int age = scanner.nextInt();
			//1:应当判定的是用户输入的年龄!
			//2:应当使用||不能使用&&
//			if(p.getAge()<0&&p.getAge()>100) {
			if(age<0||age>100) {
				System.out.println("年龄不合法!");
			}else{
				//age是Person的私有属性，不能直接访问
//			p.age = age;
				p.setAge(age);
			}
			//私有属性不能直接访问，要调用get方法获取对应属性的值
	//		System.out.println("姓名:"+p.name);
	//		System.out.println("年龄:"+p.age);
			System.out.println("姓名:"+p.getName());
			System.out.println("年龄:"+p.getAge());
		}

	}

	
}

class Person{
	private String name;
	private int age;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}