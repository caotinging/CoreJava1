package chapter15.IO.demo3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * list�����������{����,����,����,��Ѿ,Ǯ��,����},����Ѿ�滻Ϊ��СѾ,д�뵽"D:\\stuinfo.txt"
 * @author caoting
 *
 */

public class TaskDemo6 {
	public static void main(String[] args) {
		List<String> lists = new ArrayList<String>();
		lists.add("����");
		lists.add("����");
		lists.add("����");
		lists.add("��Ѿ");
		lists.add("Ǯ��");
		lists.add("����");
		
		ListIterator<String> it = lists.listIterator();
		while(it.hasNext()){
			if(it.next().equals(new String("��Ѿ")))
				it.set("��СѾ");
		}
		
		toFile(Arrays.toString(lists.toArray()));
	}
	
	//д���ļ�
	public static void toFile(String string) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(new File("G:\\stuinfo.txt"));
			writer.write(string);
			writer.flush();
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("�ļ�д��ʧ��");
		}finally {
			try{
				if(writer != null) writer.close();
			}catch(IOException e) {
				throw new RuntimeException("writer.close() failed!");
			}
		}
	}
}
