package chapter03.retirement;
/*
 * ʱ��:2017.3.9
 * ����ִ��һ�ε�ѭ���ṹ
 * */
import java.util.*;

public class RetirementP68 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.println("һ����������Ǯ��");
	double payment = in.nextDouble();
	System.out.println("�������ʶ��٣�");
	double interestRate = in.nextDouble();
	double balance = 0;
	int years = 0;
	String input;
	do{
		balance += payment;
		double interest = balance * interestRate/100;
		balance += interest;
		years++;
		System.out.printf("%d ���Ժ���Ĵ��Ϊ %,.2f%n",years,balance);
		System.out.print("Ҫ��ְ��(Y/N)");
		input = in.next();
	}
	while(input.equals("N"));
	System.out.println("�Ѽ�¼���Ĵ�ְ���룡ϣ����������죡");
	in.close();
}
}
