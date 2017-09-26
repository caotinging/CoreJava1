package chapter15.IO.demo3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * list集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫替换为王小丫,写入到"D:\\stuinfo.txt"
 * @author caoting
 *
 */

public class TaskDemo6 {
	public static void main(String[] args) {
		List<String> lists = new ArrayList<String>();
		lists.add("张三");
		lists.add("李四");
		lists.add("王五");
		lists.add("二丫");
		lists.add("钱六");
		lists.add("孙七");
		
		ListIterator<String> it = lists.listIterator();
		while(it.hasNext()){
			if(it.next().equals(new String("二丫")))
				it.set("王小丫");
		}
		
		toFile(Arrays.toString(lists.toArray()));
	}
	
	//写入文件
	public static void toFile(String string) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(new File("G:\\stuinfo.txt"));
			writer.write(string);
			writer.flush();
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("文件写入失败");
		}finally {
			try{
				if(writer != null) writer.close();
			}catch(IOException e) {
				throw new RuntimeException("writer.close() failed!");
			}
		}
	}
}
