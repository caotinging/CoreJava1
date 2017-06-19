package chapter03.firstSample;
/*
 * 时间：2017.3.9；
 * 此类用于检测循环结构学习情况
 * balance为当前总值，goal为目标值
 * payment为每年固定增加值
 * interest为每年利息
 * interestRate为利率 years为达到目标值需要的时间
 */
import java.util.*;

public class WhileP66 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	//构建标准输出；
	System.out.print("请输入当前值: ");
	int balance = in.nextInt();
	System.out.print("请输入目标值: ");
	int goal = in.nextInt();
	System.out.print("请输入每年增长的固定值: ");
	int payment = in.nextInt();
	double interest;
	System.out.print("输入利率: ");
	double interestRate = in.nextDouble();
	int years = 0;
	//输入各项数值；
	while (balance < goal){
		balance += payment;
		interest = balance * interestRate/100;
		balance += interest;
		years++;
	}
	System.out.println("\n需要"+years+"年，才能达到目标值");
	in.close();
}
}
