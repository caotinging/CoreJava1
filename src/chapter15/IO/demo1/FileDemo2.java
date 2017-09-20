package chapter15.IO.demo1;

import java.io.File;

/**
 * 利用递归实现目录的全遍历
 * @author caoting
 *
 */

public class FileDemo2 {
	public static void main(String[] args) {
		File file = new File("G:\\demo");
		getAllDir(file);
		System.out.println("==========================");
		getJava(file);
	}
	
//	方法的目的是遍历一个目录
	public static void getAllDir(File file) {
//		递归的边界条件就是遇到一个文件不再进行遍历（调用）
//		首先判断是不是一个目录  是的话进行遍历  不是的话就输出在控制台
		if(!file.exists())
			return;
		
		if(file.isDirectory() && file.listFiles().length>0) {
//			对目录进行遍历
//			这里还需检验一下目录是否为空  
			File[] files = file.listFiles();
				for(File f: files) {
	//				接着再判断是不是目录 如果是就递归调用遍历
					if(f.isDirectory()) {
						getAllDir(f);
					} else {
						System.out.println(f);
					}
				}
		}else {
			System.out.println(file);
		}
	}
	
	/*
	 * 利用自定义的过滤器获取目录中的所有java文件
	 */
	public static void getJava(File file) {
		if(!file.exists())
			return;
		if(file.isDirectory()) {
			for(File f: file.listFiles(new MyFilter())) {
				if(f.isDirectory())
					getJava(f);
				else
					System.out.println(f);
			}
		} 
		else
			System.out.println(file);
	}
}
