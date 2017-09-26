package chapter15.IO.demo1;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * 键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数,
 * 注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,用个数作为value,
 * 放入到map集合中,并用两种方式遍历map集合
 *	例如：
 *	doc 的类型的文件有  3 个
 *	java 的类型的文件有  5 个
 *	txt 的类型的文件有  7 个
 * @author caoting
 *
 */

public class TaskDemo5 {
	//构造器
	 public TaskDemo5() {
		length1 = 0;
	}

	//创建一个全局变量list保存各个过滤器下的文件
	private int length1;
	
	public static void main(String[] args) {
		//创建一个Scanner对象接收键盘数据
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要查询文件类型及数目的文件夹路径");
		String pathname = in.next();
		System.out.println("=====================");
		
		//创建一个map映射表保存文件名称和数目
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//利用pathname创建文件
		File file = new File(pathname);
		//当file不为空且存在时调用方法
		if(file != null && file.exists()) {
			//调用遍历目录方法，参数是文件路径和txt过滤器
			System.out.println("正在查询txt文件数目。。。。");
			int txt = new TaskDemo5().getFiles(file, new TxtFilter());
			//将结果保存
			map.put("txt", txt);
			
			//调用遍历目录方法，参数是文件路径和java过滤器
			System.out.println("=====================");
			System.out.println("正在查询java文件数目。。。。");
			int java1 = new TaskDemo5().getFiles(file, new JavaFilter());
			//将结果保存
			map.put("java", java1);
			
			//调用目录遍历方法，参数是文件路径和doc过滤器
			System.out.println("=====================");
			System.out.println("正在查询doc文件数目。。。。");
			int doc = new TaskDemo5().getFiles(file, new DocFilter());
			map.put("doc", doc);
			
			System.out.println("=====================");
			System.out.println("遍历map的方法一：");
			entryMap(map);
			System.out.println("=====================");
			System.out.println("遍历map的方法二：");
			keyMap(map);
		}
		else
			System.out.println("不是有效的文件路径！");
		//关闭in流
		in.close();
	}
	
	//遍历map的方法一
	public static void entryMap(Map<String, Integer> map) {
		//利用for循环和entrySet
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.print(key + "类型的文件数目为：");
			System.out.println(value);
		}
	}
	
	//遍历map的方法二
	public static void keyMap(Map<String, Integer> map) {
		//利用while循环和keySet
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = map.get(key);
			System.out.print(key + "类型的文件数目为：");
			System.out.println(value);
		}
	}
	
	//遍历目录获取文件
	private int getFiles(File file, FileFilter txtFilter) {
		if(file.isFile())
			return length1++;
		File[] files = file.listFiles(txtFilter);
		//如果是空文件夹直接返回
		if(files.length == 0)
			return length1;
		for(File f: files) {
			getFiles(f, txtFilter);
		}
		return length1;
	}
}

//过滤txt文件的过滤器
class TxtFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".txt");
	}
}

//过滤java文件的过滤器
class JavaFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".java");
	}
}

//过滤doc文件的过滤器
class DocFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".doc");
	}
}