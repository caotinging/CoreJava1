package chapter15.IO.demo4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 用代码实现以下需求
	(1)有如下字符串"If you want to change your fate I think you must
	 come to the dark horse to learn java"(用空格间隔)
	(2)打印格式：
		to=3
		think=1
		you=2
		//........
	(3)按照上面的打印格式将内容写入到D:\\count.txt文件中(要求用高效流)
 * @author caoting
 */

public class TaskDemo2 {
	public static void main(String[] args) throws IOException {
		//定义要进行操作的字符串
		String string = "If you want to change your fate I think you must come to the dark horse to learn java";
		//获取单词列表
		List<Word> words = Word.getWList(string);
		//将列表进行输出和打印
		Word.out_word(words);
		System.out.println("=====================");
		System.out.println("文件输出成功！");
	}
}

//单词类 定义了一些操作字符串中单个单词的方法
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
	
	//从一个字符串中获取单词列表的方法
	public static List<Word> getWList(String string) throws IOException {
		//创建一个从字符串读取数据的字符输入流
		StringReader sr = new StringReader(string);
		
		//初始化一个List<word>
		List<Word> list = new ArrayList<Word>();
		
		//一个只有当读到字符串末尾才break的循环
		boolean flag = true;
		while(flag) {
			//创建一个保存单词的字符数组 假定单词长度不超过15
			char[] ch = new char[15];
			int i = 0;
			int len = 0;
			
			//每一次循环读取一个单词
			while((len = sr.read()) != (int)' '){
				if(len == -1) {
					flag = false;
//					System.out.println("字符串已读取完毕！");
					break;
				}
				else{
					ch[i] = (char)len;
					i++;
//					System.out.println("单词");
				}
			}
			
			//将字符数组中保存的单词与list中每个word.str做比较 相等word.count+1 不相等添加一个word成员
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
	
	//创建一个打印word列表以及输出到文件的方法
	public static void out_word(List<Word> list) throws IOException {
		//初始化高效流绑定字符输出流和文件 
		BufferedWriter writer = new BufferedWriter(new FileWriter("G:\\count.txt"));
		//对传递过来的单词列表进行遍历
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