package chapter03.inputTest;
import java.util.*;
/*ʱ��2017.3.7
 * �����µ��߽��������
 * */
public class InputTestP55 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	//����һ��scanner�������׼������������
	System.out.println("What's you name ?");
	String name = in.nextLine();
	//nextline����������һ����
	System.out.println("Which class are you in ?");
	int cl = in.nextInt();
	//nextInt����������һ��������
	System.out.println("How many points did you get ?");
	double grade = in.nextDouble();
	//nextDouble����������һ��˫����С����
	System.out.println("hello! "+cl+"class "+name+".you hava get "+grade+" in this test!");
	in.close();
}
}
