package chapter03.retirement;
/*
 * 时间:2017.3.9
 * 至少执行一次的循环结构
 * */
import java.util.*;

public class RetirementP68 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.println("一年能挣多少钱？");
	double payment = in.nextDouble();
	System.out.println("银行利率多少？");
	double interestRate = in.nextDouble();
	double balance = 0;
	int years = 0;
	String input;
	do{
		balance += payment;
		double interest = balance * interestRate/100;
		balance += interest;
		years++;
		System.out.printf("%d 年以后，你的存款为 %,.2f%n",years,balance);
		System.out.print("要辞职吗？(Y/N)");
		input = in.next();
	}
	while(input.equals("N"));
	System.out.println("已记录您的辞职申请！希望您生活愉快！");
	in.close();
}
}
