package chapter15.IO.demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 利用递归进行文件夹的拷贝：
 * 		基本实现思想
 * 			非空目录：
 * 					文件 --->直接拷贝（copy）
 * 					目录 :
 * 						 if空目录  ---> 判断是否已存在（不存在的话创建mkdirs()）
 * 						 if非空目录：
 * 									文件 ---> 直接拷贝
 * 									目录:blablabla  可以看出递归结构了
 * @author caoting
 *
 */

public class TaskDemo2 {
	public static void main(String[] args) {
		//创建一个scanne对象接收键盘数据：两个文件夹
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要复制的文件夹");
		String begin = in.next();
		System.out.println("请输入目标文件夹：");
		String target = in.next();
		System.out.println("===================");
		
		File bFile = new File(begin);
		//判断文件路径是否有效
		if(bFile==null || target==null) {
			System.out.println("文件路径无效！");
		}
		else{
			//调用复制的方法
			copyDir(bFile, target);
		}
		//关闭in流
		in.close();
	}

	public static void copyDir(File begin, String target) {
		//判断是文件还是目录
		File targetFile = new File(target);
		
		if(begin.isFile())
			//如果是文件调用文件复制方法
			copy(begin, targetFile);
		else {
			//判断该目录是否存在 不存在就创建
			if(!targetFile.exists())
				targetFile.mkdirs();
			
			File[] files = begin.listFiles();
			for(File f: files) {
				copyDir(f, target+"\\"+f.getName());
			}
		}
	}

	//文件复制方法
	public static void copy(File bFile, File tFile) {
		//创建一个字节输入流和一个字节输出流
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		//处理IO异常
		try {
			fileInputStream = new FileInputStream(bFile);
			fileOutputStream = new FileOutputStream(tFile);
			//创建一个字节数组用于缓冲
			byte[] bytes = new byte[1024];
			//利用while循环进行复制
			int len = 0;
			while((len = fileInputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, len);
			}
			
		}catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("文件复制失败");
		}finally {
			//关闭流也有需要捕捉的异常：先开后关，先关输出流
			//关闭流之前先判断是否为null
			try {
				if(fileOutputStream != null)
					fileOutputStream.close();
			}catch(IOException e) {
				throw new RuntimeException("FileOutPutStream流关闭失败！");
			}finally {
				try{
					if(fileInputStream != null)
						fileInputStream.close();
				}catch(IOException e) {
					throw new RuntimeException("FileInputStream流关闭失败！");
				}
			}
		}
	}
}
