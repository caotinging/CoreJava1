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
 * 1.�ô���ʵ����������
	(1)����ѧ����,��������(String name),�Ա�(String gender),����(int age)��������,���ɿղ��вι���,
		set��get����,toString����
	(2)����¼��6��ѧԱ��Ϣ(¼���ʽ:����,��,25),Ҫ����������ͬ����Ϣ,��6��ѧԱ��Ϣ���뵽ArrayList������
	(3)������6��ѧԱ��Ϣ��ArrayList���϶���д�뵽D:\\StudentInfo.txt�ļ���
	(4)��ȡD:\\StudentInfo.txt�ļ��е�ArrayList����
	(5)��ArrayList�����е�6��ѧ���������ȥ�ز����������С�����˳������
	(6)��ArrayList�����������Ľ������PrintWriter��д�뵽E:\\StudentInfo.txt�ļ���(д���ʽ������-��-25)
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
	
	//(6)��ArrayList�����������Ľ������PrintWriter��д�뵽E:\\StudentInfo.txt�ļ���(д���ʽ������-��-25)
	public static void writeSort(List<StudentInfo> list) throws IOException {
		FileWriter fw = new FileWriter("E:\\StudentInfo.txt");
		PrintWriter writer = new PrintWriter(fw);
		for(StudentInfo stu: list) {
			String s = stu.getName()+"-"+stu.getSex()+"-"+stu.getAge();
			writer.println(s);
		}
		writer.close();
		System.out.println("д��ɹ�");
	}
	
	
	//(5)��ArrayList�����е�6��ѧ���������ȥ�ز����������С�����˳������
	public static List<StudentInfo> sortStu(List<StudentInfo> list) {
		//����ȥ�ط���һ���ñ���
		for(int i=0; i<list.size(); i++) {
			for(int j=list.size()-1; j>i; j--) {
				if(list.get(i).equals(list.get(j)))
					list.remove(i);
			}
		}
		//����
		Comparator<StudentInfo> comp = new StudentInfo();//StudentInfo�ıȽ���
		Collections.sort(list, comp);
		System.out.println(list);
		return list;
	}
	
	//(4)��ȡD:\\StudentInfo.txt�ļ��е�ArrayList����
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
	
	//(3)������6��ѧԱ��Ϣ��ArrayList���϶���д�뵽D:\\StudentInfo.txt�ļ���
	public static void writeToFile(List<StudentInfo> list) throws IOException {
		//���ù�����
//		FileUtils.writeStringToFile(new File("D:\\StudentInfo.txt"), list.toString());
		//ʹ�ô�ӡ��
		/*PrintWriter pw = new PrintWriter("D:\\StudentInfo.txt");
		for(StudentInfo student: list) {
			pw.println(student.toString());
			//�Զ�ˢ��
		}
		//		pw.close();
		*/
		
		//ʹ�����л��ͷ����л� StudentInfoʵ����Serializable�ӿ�
		FileOutputStream fos = new FileOutputStream("D:\\StudentInfo.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(StudentInfo stu: list) {
			oos.writeObject(stu);
		}
		oos.close();
	}
	
	//(2)����¼��6��ѧԱ��Ϣ(¼���ʽ:����,��,25)
	public static List<StudentInfo> printStu() {
		List<StudentInfo> list = new ArrayList<StudentInfo>();
		//����¼��
		Scanner in = new Scanner(System.in);
		for(int i = 0; i<6; i++) {
			System.out.print("�������"+i+"����  ");
			//����ָ���ķָ����ָ��ַ���
			String[] strs = in.nextLine().split(",");
			StudentInfo stu = new StudentInfo(strs[0], strs[1], Integer.parseInt(strs[2]));
			list.add(stu);
		}
		
		//System.out.println(list);
		in.close();
		return list;
	}
}
