package chapter03.firstSample;
/*
 * ʱ�䣺2017.3.9��
 * �������ڼ��ѭ���ṹѧϰ���
 * balanceΪ��ǰ��ֵ��goalΪĿ��ֵ
 * paymentΪÿ��̶�����ֵ
 * interestΪÿ����Ϣ
 * interestRateΪ���� yearsΪ�ﵽĿ��ֵ��Ҫ��ʱ��
 */
import java.util.*;

public class WhileP66 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	//������׼�����
	System.out.print("�����뵱ǰֵ: ");
	int balance = in.nextInt();
	System.out.print("������Ŀ��ֵ: ");
	int goal = in.nextInt();
	System.out.print("������ÿ�������Ĺ̶�ֵ: ");
	int payment = in.nextInt();
	double interest;
	System.out.print("��������: ");
	double interestRate = in.nextDouble();
	int years = 0;
	//���������ֵ��
	while (balance < goal){
		balance += payment;
		interest = balance * interestRate/100;
		balance += interest;
		years++;
	}
	System.out.println("\n��Ҫ"+years+"�꣬���ܴﵽĿ��ֵ");
	in.close();
}
}
