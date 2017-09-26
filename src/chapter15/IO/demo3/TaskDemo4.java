package chapter15.IO.demo3;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 键盘输入10个数，放到数组中
	(1)去除该数组中大于10的数
	(2)将该数组中的数字写入到本地文件number.txt中
 * @author caoting
 *
 */

public class TaskDemo4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[10];
		System.out.println("请输入10个数：");
		
		for(int i = 1; i<=10; i++) {
			System.out.print("第" +i+ "个：");
			arr[i-1] = in.nextInt();
			System.out.println("========");
		}
		
		ArrTen arrten = new ArrTen(arr);
		//调用ArrTen类中方法去除大于10的数
		int[] arr1 = arrten.removeBig();
		
		System.out.println("请输入要写入数据的文件路径");
		
		File file = new File(in.next());
		//调用写入文件的方法
		if(file!=null) {
			ArrTen.outputToFile(file, Arrays.toString(arr1));
			System.out.println("文件写入成功！");
		}
		in.close();
	}
}
