package chapter15.IO.demo4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * �ô���ʵ����������
	(1)�������ַ���"If you want to change your fate I think you must
	 come to the dark horse to learn java"(�ÿո���)
	(2)��ӡ��ʽ��
		to=3
		think=1
		you=2
		//........
	(3)��������Ĵ�ӡ��ʽ������д�뵽D:\\count.txt�ļ���(Ҫ���ø�Ч��)
 * @author caoting
 */

public class TaskDemo2 {
	public static void main(String[] args) throws IOException {
		//����Ҫ���в������ַ���
		String string = "If you want to change your fate I think you must come to the dark horse to learn java";
		//��ȡ�����б�
		List<Word> words = Word.getWList(string);
		//���б��������ʹ�ӡ
		Word.out_word(words);
		System.out.println("=====================");
		System.out.println("�ļ�����ɹ���");
	}
}

//������ ������һЩ�����ַ����е������ʵķ���
class Word {
	private String str;
	private int count;
	
	public Word() {
		str = new String();
		count = 0;
	}
	
	public Word(String s) {
		str = s;
		count = 1;
	}
	
	//��һ���ַ����л�ȡ�����б�ķ���
	public static List<Word> getWList(String string) throws IOException {
		//����һ�����ַ�����ȡ���ݵ��ַ�������
		StringReader sr = new StringReader(string);
		
		//��ʼ��һ��List<word>
		List<Word> list = new ArrayList<Word>();
		
		//һ��ֻ�е������ַ���ĩβ��break��ѭ��
		boolean flag = true;
		while(flag) {
			//����һ�����浥�ʵ��ַ����� �ٶ����ʳ��Ȳ�����15
			char[] ch = new char[15];
			int i = 0;
			int len = 0;
			
			//ÿһ��ѭ����ȡһ������
			while((len = sr.read()) != (int)' '){
				if(len == -1) {
					flag = false;
//					System.out.println("�ַ����Ѷ�ȡ��ϣ�");
					break;
				}
				else{
					ch[i] = (char)len;
					i++;
//					System.out.println("����");
				}
			}
			
			//���ַ������б���ĵ�����list��ÿ��word.str���Ƚ� ���word.count+1 ��������һ��word��Ա
			String s = new String(ch);
			int flag2 = 0;
			for(Word w: list) {
				if(s.equals(w.str)) {
					w.count++;
					flag2 = 1;
					break;
				}
			}
			if(flag2 == 0) {
				Word nw = new Word(s);
				list.add(nw);
			}
		}
		sr.close();
		return list;
	}
	
	//����һ����ӡword�б��Լ�������ļ��ķ���
	public static void out_word(List<Word> list) throws IOException {
		//��ʼ����Ч�����ַ���������ļ� 
		BufferedWriter writer = new BufferedWriter(new FileWriter("G:\\count.txt"));
		//�Դ��ݹ����ĵ����б���б���
		for(Word w: list) {
			String s = w.str + " = " + w.count;
			writer.write(s);
			writer.newLine();
			writer.flush();
			System.out.println(s);
		}
		writer.close();
	}
}