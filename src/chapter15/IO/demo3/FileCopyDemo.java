package chapter15.IO.demo3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流复制文本文件
 * 字符流查询本机默认的编码表，简体中文GBK
 * FileReader读取数据源
 * FileWriter写入到数据目的
 * @author caoting
 */

public class FileCopyDemo {
	public static void main(String[] args) {
		//创建指定文件路径的文件file1(数据源) file2(数据目的)
		File file1 = new File("G:\\1.txt");
		File file2 = new File("D:\\1.txt");
		//调用文件复制方法
		copyFile(file1, file2);
		System.out.println("复制成功！");
	}

	//利用字符流完成文本文件复制
	private static void copyFile(File file1, File file2) {
		FileWriter writer = null;
		FileReader reader = null;
		try {
			reader = new FileReader(file1);
			writer = new FileWriter(file2);
			
			int len = -1;
			char[] cs = new char[1024];
			while((len = reader.read(cs)) != -1) {
				writer.write(cs, 0, len);
				writer.flush();//写一次刷一次
			}
		} catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("文件复制失败");
		} finally {
			try{
				if(writer!=null) writer.close();
				if(reader!=null) reader.close();
			} catch(IOException ex) {
				throw new RuntimeException("释放资源失败");
			}
		}
	}
}
