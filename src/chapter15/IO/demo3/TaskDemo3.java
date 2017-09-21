package chapter15.IO.demo3;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取指定目录及子目录下所有txt文件的个数，并将这些txt文件复制到D盘下任意目录
 * @author caoting
 *
 */

public class TaskDemo3 {
	//设置一个静态全局变量用于保存txt文件
	static List<File> list = new ArrayList<File>();	
	
	public static void main(String[] args) {
		//设置获取txt文件的指定目录
		File file = new File("G:\\abc");
		//调用获取txt文件的方法
		getTxt(file);
		System.out.println("txt文件的数目为：" + list.size());
		System.out.println("==================");
		System.out.println("执行复制操作");
		copy(list, "D:\\abc");
		System.out.println("==================");
		System.out.println("复制成功！");
	}
	
	//文件列表复制功能
	public static void copy(List<File> list2, String path) {
		File file = new File(path);
		if(!file.exists())
			file.mkdirs();
		for(File f: list2) {
			copyFile(f, file + "\\" + f.getName());
		}
	}

	private static void copyFile(File f, String file) {
		//创建一个字节输入流和一个字节输出流
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		//处理IO异常
		try {
			fileInputStream = new FileInputStream(f);
			fileOutputStream = new FileOutputStream(file);
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

	//获取目录中的txt文件
	public static void getTxt(File file) {
		File[] files = file.listFiles(new TxtFilter());
		//判断是否为空文件夹
		if(files.length == 0)
			return;
		for(File f: files) {
			if(f.isFile())
				//如果f是txt文件 保存入list中
				list.add(f);
			else {
				getTxt(f);
			}
		}
	}
}

//实现了FileFiter接口的过滤txt文件的类
class TxtFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".txt");
	}
}
