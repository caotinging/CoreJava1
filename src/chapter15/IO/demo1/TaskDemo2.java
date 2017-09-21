package chapter15.IO.demo1;

import java.io.File;
import java.util.Scanner;

/**
 * 从键盘接收一个文件夹路径,统计该文件夹大小
 * @author caoting
 *
 */

public class TaskDemo2 {
	
	public static void main(String[] args) {
		System.out.println("请输入要计算大小的路径");
		Scanner in = new Scanner(System.in);
		//从键盘接收一个文件路径
		String srcString = in.next();
		//将路径传递给计算文件大小的方法
		getSize(srcString);
		//关闭输入流
		in.close();
	}
	//声明用于保存文件夹大小的全局变量
	static long sum;
	
	//创建计算文件夹大小的方法
	public static void getSize(String s) {
		File file = new File(s);
		//判断路径是否存在以及s是否为空
		if(file == null || !file.exists()) {
			System.out.println("文件路径不存在！");
			return;
		}
		if(!file.isDirectory()) 
			System.out.println("文件大小为：" + file.length());
		else {
			//判断文件夹是否为空
			File[] files = file.listFiles();
			if(files.length == 0) {
				System.out.println("文件夹为空！");
				return;
			}
			//调用遍历目录方法
			dirs(file);
			System.out.println("文件夹大小为：" + sum);
		}
	}
	
	//创建遍历计算文件大小的方法
	public static void dirs(File pathname) {
		if(!pathname.isDirectory()) {
			sum += pathname.length();
			return;
		}
		else {
			File[] files = pathname.listFiles();
			if(files.length == 0)
				return;
			for(File f: files) {
				dirs(f);
			}
		}
	}
}
