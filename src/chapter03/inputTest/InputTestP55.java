package chapter03.inputTest;
import java.util.*;
/*时间2017.3.7
 * 第三章第七节输入输出
 * */
public class InputTestP55 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	//构建一个scanner对象与标准输入流关联；
	System.out.println("What's you name ?");
	String name = in.nextLine();
	//nextline方法将输入一整行
	System.out.println("Which class are you in ?");
	int cl = in.nextInt();
	//nextInt方法将输入一个整数；
	System.out.println("How many points did you get ?");
	double grade = in.nextDouble();
	//nextDouble方法将输入一个双精度小数；
	System.out.println("hello! "+cl+"class "+name+".you hava get "+grade+" in this test!");
	in.close();
}
}
