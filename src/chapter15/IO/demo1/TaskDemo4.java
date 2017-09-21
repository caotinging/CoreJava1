package chapter15.IO.demo1;

import java.io.File;
import java.util.Scanner;

/**
 * 从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印
 *	例如:
 *	aaa是文件夹,里面有bbb.txt,ccc.txt,ddd.txt这些文件,有eee这样的文件夹,eee中有fff.txt和ggg.txt,打印出层级来
 *	aaa
 *		bbb.txt
 *		ccc.txt
 *		ddd.txt	
 *		eee
 *			fff.txt
 *			ggg.txt
 * @author caoting
 *
 */

public class TaskDemo4 {
	public static void main(String[] args) {
		System.out.println("请输入要打印的文件夹路径：");
		//创建一个scanner对象接收键盘数据
		Scanner in = new Scanner(System.in);
		String pathname = in.next();
		//调用打印方法
		printDir(pathname);
		//关闭输入流
		in.close();
	}
	
	//创建一个按层级打印的方法
	public static void printDir(String pathname) {
		if(pathname == null) {
			System.out.println("无效的文件路径");
			return;
		}
		File file = new File(pathname);
		if(!file.exists()) {
			System.out.println("无效的文件路径");
			return;
		}
		if(file.isFile()) {
			System.out.println(file.getName());
			return;
		}
		else {
			//如果是目录调用递归方法
			printDirs(file);
		}
	}
	
	//创建一个递归遍历目录的方法
	public static void printDirs(File file) {
		//判断是不是文件夹
		if(file.isDirectory()) {
			System.out.println(file.getName());
			//判断是否为空
			File[] files = file.listFiles();
			if(files.length == 0)
				return;
			else {
				for(File f: files) {
					System.out.print("     ");
					printDirs(f);
				}
			}
		}
		else {
			System.out.print("     ");
			System.out.println(file.getName());
		}
	}
}
