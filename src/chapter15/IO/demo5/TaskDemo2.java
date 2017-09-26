package chapter15.IO.demo5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 2.用代码实现以下需求：
	(1)已知配置文件config.properties中有三个键值对
   		name=zhangsan
   		score=80
   		address=beijing
	(2)使用IO字节流对象和Properties类结合使用,将配置文件中的score键的值修改为100
 * @author caoting
 */

public class TaskDemo2 {
	public static void main(String[] args) throws IOException {
		changeScore();
	}
	
	//修改score键的值
	public static void changeScore() throws IOException {
		//创建一个字符串输入流以读取文件中的键值对
		FileReader fr = new FileReader("D:\\config.properties");
		Properties pro = new Properties();
		pro.load(fr);
		System.out.println(pro);
		fr.close();
		//进行更改操作
		System.out.println("=============================");
		
		FileWriter fw = new FileWriter("D:\\config.properties");
		pro.setProperty("score", "80");
		pro.store(fw, "update");
		fw.close();
		System.out.println(pro);
	}
}
