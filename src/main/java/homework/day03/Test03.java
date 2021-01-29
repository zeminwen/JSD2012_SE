package homework.day03;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 将当前目录下的所有文件都复制一份，复制的文件命名为:原
 * 文件名_cp.后缀
 * 比如原文件为:test.dat
 * 复制后的文件为:test_cp.dat
 * 
 * 
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) throws IOException {
		//1获取当前目录下的所有文件
		File dir = new File(".");
		if(dir.isDirectory()){
			//此过滤器的过滤规则为File对象表示的是一个文件就要
			FileFilter filter = new FileFilter() {
				public boolean accept(File file) {
					return file.isFile();
				}
			};
//			FileFilter filter = (file)->file.isFile();
			File[] subs = dir.listFiles(filter);
			//2遍历所有获取回来的文件并进行复制
			for(int i=0;i<subs.length;i++){
				//获取每个子项的文件名
				String fileName = subs[i].getName();
				//fileName:  test.dat
				//将文件名拆分为两部分，名字和后缀
				int index = fileName.lastIndexOf(".");//找到文件名中最后一个"."的位置
				//截取文件名:test
				String name = fileName.substring(0,index);
				//截取后缀名:.dat
				String ext = fileName.substring(index);
				//创建复制文件的名字
				String copyFileName = name+"_cp"+ext;
				RandomAccessFile src
						= new RandomAccessFile(subs[i],"r");
				RandomAccessFile desc
						= new RandomAccessFile(copyFileName,"rw");
				int d;
				while((d = src.read())!=-1){
					desc.write(d);
				}
				System.out.println("复制完毕!");
				src.close();
				desc.close();
			}

		}
	}
}




/**
 * 思路:
 * 分为几部分考虑.
 * 第一个是要获取到当前目录中的所有文件(思考哪个API可以解决)
 * 第二个是获取到的每一个文件都要复制(复制用什么API)
 * 第三个是复制的文件名，如何重新组建xxx_cp.xxx的名字?
 *      这里要将原文件名拆开后想办法拼接_cp.
 */


