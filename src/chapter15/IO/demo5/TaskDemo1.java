package chapter15.IO.demo5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//import org.apache.commons.io.FileUtils;

/**
 * 1.用代码实现以下需求
	(1)定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性,生成空参有参构造,
		set和get方法,toString方法
	(2)键盘录入6个学员信息(录入格式:张三,男,25),要求有两个相同的信息,将6个学员信息存入到ArrayList集合中
	(3)将存有6个学员信息的ArrayList集合对象写入到D:\\StudentInfo.txt文件中
	(4)读取D:\\StudentInfo.txt文件中的ArrayList对象
	(5)对ArrayList集合中的6个学生对象进行去重并按照年龄从小到大的顺序排序
	(6)将ArrayList集合中排序后的结果利用PrintWriter流写入到E:\\StudentInfo.txt文件中(写入格式：张三-男-25)
 * @author caoting
 *
 */

public class TaskDemo1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<StudentInfo> list = new ArrayList<StudentInfo>();
//		list = printStu();
//		writeToFile(list);
		list = readFromFile();
		list = sortStu(list);
		writeSort(list);
	}
	
	//(6)将ArrayList集合中排序后的结果利用PrintWriter流写入到E:\\StudentInfo.txt文件中(写入格式：张三-男-25)
	public static void writeSort(List<StudentInfo> list) throws IOException {
		FileWriter fw = new FileWriter("E:\\StudentInfo.txt");
		PrintWriter writer = new PrintWriter(fw);
		for(StudentInfo stu: list) {
			String s = stu.getName()+"-"+stu.getSex()+"-"+stu.getAge();
			writer.println(s);
		}
		writer.close();
		System.out.println("写入成功");
	}
	
	
	//(5)对ArrayList集合中的6个学生对象进行去重并按照年龄从小到大的顺序排序
	public static List<StudentInfo> sortStu(List<StudentInfo> list) {
		//进行去重方法一利用遍历
		for(int i=0; i<list.size(); i++) {
			for(int j=list.size()-1; j>i; j--) {
				if(list.get(i).equals(list.get(j)))
					list.remove(i);
			}
		}
		//排序
		Comparator<StudentInfo> comp = new StudentInfo();//StudentInfo的比较器
		Collections.sort(list, comp);
		System.out.println(list);
		return list;
	}
	
	//(4)读取D:\\StudentInfo.txt文件中的ArrayList对象
	public static List<StudentInfo> readFromFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("D:\\StudentInfo.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<StudentInfo> list = new ArrayList<StudentInfo>();
		
		while(true) {
			try {
				list.add((StudentInfo)ois.readObject());
			} catch (EOFException e) {
				break;
			}
		}
		
		ois.close();
		System.out.println(list);
		return list;
	}
	
	//(3)将存有6个学员信息的ArrayList集合对象写入到D:\\StudentInfo.txt文件中
	public static void writeToFile(List<StudentInfo> list) throws IOException {
		//利用工具类
//		FileUtils.writeStringToFile(new File("D:\\StudentInfo.txt"), list.toString());
		//使用打印流
		/*PrintWriter pw = new PrintWriter("D:\\StudentInfo.txt");
		for(StudentInfo student: list) {
			pw.println(student.toString());
			//自动刷新
		}
		//		pw.close();
		*/
		
		//使用序列化和反序列化 StudentInfo实现了Serializable接口
		FileOutputStream fos = new FileOutputStream("D:\\StudentInfo.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(StudentInfo stu: list) {
			oos.writeObject(stu);
		}
		oos.close();
	}
	
	//(2)键盘录入6个学员信息(录入格式:张三,男,25)
	public static List<StudentInfo> printStu() {
		List<StudentInfo> list = new ArrayList<StudentInfo>();
		//键盘录入
		Scanner in = new Scanner(System.in);
		for(int i = 0; i<6; i++) {
			System.out.print("请输入第"+i+"个：  ");
			//按照指定的分隔符分割字符串
			String[] strs = in.nextLine().split(",");
			StudentInfo stu = new StudentInfo(strs[0], strs[1], Integer.parseInt(strs[2]));
			list.add(stu);
		}
		
		//System.out.println(list);
		in.close();
		return list;
	}
}
