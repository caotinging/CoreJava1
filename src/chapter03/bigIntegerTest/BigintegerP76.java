package chapter03.bigIntegerTest;
/*
 * ʱ��:2017.3.10
 * �Ľ��ĳ齱������ֵת��Ϊ����ֵ
 * */
import java.math.*;
import java.util.*;

public class BigintegerP76 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.print("How many numbers do you need to draw? ");
	int k = in.nextInt();
	System.out.print("What is the highest number you can draw ?");
	int n = in.nextInt();
	BigInteger lotteryOdds = BigInteger.valueOf(1);
	for(int i = 1;i <= k;i++){
		lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
	}//����ֵ��Ӧ��ѭ�������
	System.out.println("Your odds are 1 in "+lotteryOdds+". Good Luck !");
	in.close();
	//Ӧ��ע��ر�����������������Դ��©�ľ���
}
}
