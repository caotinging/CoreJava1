package chapter15.IO.demo3;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 产生10个1-100的随机数，并放到一个数组中
	(1)把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
	(2)把数组中的数字放到当前文件夹的number.txt文件中
 * @author caoting
 *
 */

public class TaskDemo5 {
	public static void main(String[] args) {
		//创建一个ArrRandom对象，ArrRandom的构造器自动的生成一个随机数组
		ArrRandom arrR = new ArrRandom();
		//调用获取大于10的数字的方法
		List<Double> list = arrR.getBig();
		//将list转换为String传递给ArrTen类中的outputToFile方法
		String string = Arrays.toString(list.toArray());
		ArrTen.outputToFile(new File("G:\\number.txt"), string);
		System.out.println("\n=============================");
		System.out.println("写入成功！");
	}
}
