package chapter15.IO.demo5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 2.�ô���ʵ����������
	(1)��֪�����ļ�config.properties����������ֵ��
   		name=zhangsan
   		score=80
   		address=beijing
	(2)ʹ��IO�ֽ��������Properties����ʹ��,�������ļ��е�score����ֵ�޸�Ϊ100
 * @author caoting
 */

public class TaskDemo2 {
	public static void main(String[] args) throws IOException {
		changeScore();
	}
	
	//�޸�score����ֵ
	public static void changeScore() throws IOException {
		//����һ���ַ����������Զ�ȡ�ļ��еļ�ֵ��
		FileReader fr = new FileReader("D:\\config.properties");
		Properties pro = new Properties();
		pro.load(fr);
		System.out.println(pro);
		fr.close();
		//���и��Ĳ���
		System.out.println("=============================");
		
		FileWriter fw = new FileWriter("D:\\config.properties");
		pro.setProperty("score", "80");
		pro.store(fw, "update");
		fw.close();
		System.out.println(pro);
	}
}
