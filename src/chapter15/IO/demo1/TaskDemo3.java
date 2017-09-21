package chapter15.IO.demo1;

import java.io.File;
import java.util.Scanner;

/**
 * 从键盘接收一个文件夹路径,删除该文件夹
 * @author caoting
 *
 */

public class TaskDemo3 {
	//由于delete方法只能删除文件和空文件夹，因此我们需要两个方法：
	//一个用于删除空的文件夹以及本身就是文件的路径，一个递归删除目录中文件的方法
	public static void main(String[] args) {
		System.out.println("请输入要删除的路径：（删除有风险，运行需谨慎）");
		//首先创建一个Scanner对象获取键盘输入
		Scanner in = new Scanner(System.in);
		String pathname = in.next();
		//调用删除方法；
		if(pathname != null)
			delDirs(pathname);
		//不要忘记关闭输入流
		in.close();
	}
	
	//创建删除空文件夹和文件的方法
	public static void delDirs(String pathname) {
		File file = new File(pathname);
		//判断是否为有效路径
		if(file == null || !file.exists()) {
			System.out.println("不是有效路径");
			return;
		}
		if(file.isFile()) {
			file.delete();
			System.out.println("文件删除成功");
		}
		else {
			delFile(file);
			if(file.exists())
				file.delete();
			System.out.println("文件删除成功！");
		}
	}
	
	//创建遍历删除文件目录中文件的方法
	public static void delFile(File file) {
		//判断是否为文件夹
		if(file.isFile()) {
			file.delete();
			return;
		}
		else {
			File[] files = file.listFiles();
			//判断是否为空
			if(files.length == 0) {
				file.delete();
				return;
			}
			//如果不是文件也不是空目录进行遍历递归调用
			for(File f: files) {
				delFile(f);
				//这一步不能少：当删除层级目录下边的文件往上返回的时候目录已经空了但是不经过上面的检测了，
				//因此只能在这一步删除那些因为文件被删除变空的目录
				if(f.exists())
					f.delete();
			}
		}
	}
}
