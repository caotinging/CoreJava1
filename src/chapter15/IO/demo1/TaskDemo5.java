package chapter15.IO.demo1;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * ����¼��һ���ļ���·��,ͳ�Ƹ��ļ���(�������ļ���)��ÿ�����͵��ļ�������,
 * ע��:���ļ�����(��׺��,������.(��),�磺"java","txt")��Ϊkey,�ø�����Ϊvalue,
 * ���뵽map������,�������ַ�ʽ����map����
 *	���磺
 *	doc �����͵��ļ���  3 ��
 *	java �����͵��ļ���  5 ��
 *	txt �����͵��ļ���  7 ��
 * @author caoting
 *
 */

public class TaskDemo5 {
	//������
	 public TaskDemo5() {
		length1 = 0;
	}

	//����һ��ȫ�ֱ���list��������������µ��ļ�
	private int length1;
	
	public static void main(String[] args) {
		//����һ��Scanner������ռ�������
		Scanner in = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ�ļ����ͼ���Ŀ���ļ���·��");
		String pathname = in.next();
		System.out.println("=====================");
		
		//����һ��mapӳ������ļ����ƺ���Ŀ
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//����pathname�����ļ�
		File file = new File(pathname);
		//��file��Ϊ���Ҵ���ʱ���÷���
		if(file != null && file.exists()) {
			//���ñ���Ŀ¼�������������ļ�·����txt������
			System.out.println("���ڲ�ѯtxt�ļ���Ŀ��������");
			int txt = new TaskDemo5().getFiles(file, new TxtFilter());
			//���������
			map.put("txt", txt);
			
			//���ñ���Ŀ¼�������������ļ�·����java������
			System.out.println("=====================");
			System.out.println("���ڲ�ѯjava�ļ���Ŀ��������");
			int java1 = new TaskDemo5().getFiles(file, new JavaFilter());
			//���������
			map.put("java", java1);
			
			//����Ŀ¼�����������������ļ�·����doc������
			System.out.println("=====================");
			System.out.println("���ڲ�ѯdoc�ļ���Ŀ��������");
			int doc = new TaskDemo5().getFiles(file, new DocFilter());
			map.put("doc", doc);
			
			System.out.println("=====================");
			System.out.println("����map�ķ���һ��");
			entryMap(map);
			System.out.println("=====================");
			System.out.println("����map�ķ�������");
			keyMap(map);
		}
		else
			System.out.println("������Ч���ļ�·����");
		//�ر�in��
		in.close();
	}
	
	//����map�ķ���һ
	public static void entryMap(Map<String, Integer> map) {
		//����forѭ����entrySet
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.print(key + "���͵��ļ���ĿΪ��");
			System.out.println(value);
		}
	}
	
	//����map�ķ�����
	public static void keyMap(Map<String, Integer> map) {
		//����whileѭ����keySet
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = map.get(key);
			System.out.print(key + "���͵��ļ���ĿΪ��");
			System.out.println(value);
		}
	}
	
	//����Ŀ¼��ȡ�ļ�
	private int getFiles(File file, FileFilter txtFilter) {
		if(file.isFile())
			return length1++;
		File[] files = file.listFiles(txtFilter);
		//����ǿ��ļ���ֱ�ӷ���
		if(files.length == 0)
			return length1;
		for(File f: files) {
			getFiles(f, txtFilter);
		}
		return length1;
	}
}

//����txt�ļ��Ĺ�����
class TxtFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".txt");
	}
}

//����java�ļ��Ĺ�����
class JavaFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".java");
	}
}

//����doc�ļ��Ĺ�����
class DocFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".doc");
	}
}