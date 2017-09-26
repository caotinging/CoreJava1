package chapter15.IO.demo3;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 从控制台获取输入的文件目录然后将该目录(包含子目录)下的.java文件复制到D:/java文件夹中
 * @author caoting
 *
 */

public class TaskDemo7 {
	public static void main(String[] args) {
		System.out.println("请输入需要复制java文件的文件夹路径:");
		Scanner in = new Scanner(System.in);
		String src = in.next();
		
		String des = new String("G:\\java");
		if(!new File(des).exists())
			new File(des).mkdirs();
		
		File file = new File(src);
		if(file.isFile()) {
			if(file.getName().endsWith(".java"))
				FileListA.copyFiles(file, des+"\\"+file.getName());
		}
		
		if(file!=null && file.isDirectory() && file.exists()) {
			
			//调用获取全部java文件的方法
			FileListA fileList = new FileListA();
			fileList.getFiles(file);
			//遍历FileListA类中list获取java文件 分别进行复制
			for(File f: fileList.list) {
				//复制每一个java文件
				FileListA.copyFiles(f, des+"\\"+f.getName());
			}
		}
		else{
			System.out.println("不是有效的文件夹！");
		}
		
		System.out.println("======================");
		System.out.println("文件成功复制");
		
		in.close();
	}
}

class FileListA {
	List<File> list;
	
	public FileListA () {
		list = new ArrayList<File>();
	}
	
	//复制文件的方法
	public static void copyFiles(File src, String des) {
		FileReader reader = null;
		FileWriter writer = null;
		try{
			reader = new FileReader(src);
			writer = new FileWriter(des);
			
			int len = 0;
			char[] ch = new char[1024];
			
			while((len = reader.read(ch)) != -1) {
				writer.write(ch, 0, len);
				writer.flush();
			}
		}catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("文件复制失败！");
		}finally{
			try{
				if(reader!=null) reader.close();
				if(writer!=null) writer.close();
			}catch(IOException ex){
				throw new RuntimeException("释放资源失败！");
			}
		}
	}
	
	//遍历目录
	public void getFiles(File file) {
		//判断是否是文件
		if(file.isFile()) {
			list.add(file);
			return;
		}
		File[] files = file.listFiles(new FilterA());
		if(files.length == 0)
			return;
		for(File f: files) {
			getFiles(f);
		}
	}
}
class FilterA implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".java");
	}
	
}