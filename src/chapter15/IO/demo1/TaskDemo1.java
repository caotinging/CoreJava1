package chapter15.IO.demo1;

/**
 * 使用文件名称过滤器筛选将指定文件夹下的小于200K的小文件获取并打印
 */

import java.io.File;
import java.io.FileFilter;

public class TaskDemo1 {
	public static void main(String[] args) {
//		创建一个文件
		File file = new File("D:\\MyEclipse 2015");
		
//		调用递归方法遍历目录 打印小于200k的文件
		getSmall(file);
	}
	
	public static void getSmall(File aFile) {
		//首先检测参数路径是否存在
		if(!aFile.exists())
			return;
		//然后检测file是否为一个目录且目录不为空
		if(aFile.isDirectory() && aFile.list().length>0) {
			//遍历该目录
			File[] files = aFile.listFiles(new filter11());
			for(File f: files) {
				if(f.isDirectory())
					getSmall(f);
				else
					System.out.println(f);
			}
		}
		else
			System.out.println(aFile);
	}
}
class filter11 implements FileFilter {
	public boolean accept(File pathname) {
		//获取文件小于200k的文件 如果是目录直接true
		if(pathname.isDirectory())
			return true;
		return (pathname.length())/1024 < 200;
	}
}