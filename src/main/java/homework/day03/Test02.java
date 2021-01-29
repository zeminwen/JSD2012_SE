package homework.day03;

import java.io.File;
import java.io.FileFilter;

/**
 * 列出当前目录中所有名字包含s的子项。
 * 
 * 使用匿名内部类和lambda两种写法
 * 
 * 单词记一记:
 * FileFilter   文件过滤器
 * accept       接受
 * 
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		File dir = new File(".");
		//判断当前File对象表示的是否为一个目录
		if(dir.isDirectory()){
//			FileFilter filter = new FileFilter() {
//				public boolean accept(File file) {
//					return file.getName().contains("s");
//				}
//			};
			FileFilter filter =
					(file)->file.getName().contains("s");

			File[] subs = dir.listFiles(filter);
			System.out.println(subs.length);
			for(int i=0;i<subs.length;i++){
				System.out.println(subs[i].getName());
			}
		}
		
	}
}
