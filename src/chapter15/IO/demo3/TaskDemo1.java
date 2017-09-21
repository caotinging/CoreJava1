package chapter15.IO.demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 从键盘接收两个文件路径，进行文件拷贝
 * @author caoting
 *
 */
public class TaskDemo1 {
	public static void main(String[] args) {
		//创建一个scanne对象接收键盘数据：两个文件夹
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要复制的文件夹");
		String begin = in.next();
		System.out.println("请输入目标文件夹：");
		String target = in.next();
		System.out.println("===================");
		//调用复制的方法
		copyDir(begin, target);
		//关闭in流
		in.close();
	}

	public static void copyDir(String begin, String target) {
		File bFile = new File(begin);
		File tFile = new File(target);
		//判断文件路径是否有效
		if(bFile==null || tFile==null) {
			System.out.println("文件路径无效！");
			return;
		}
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
