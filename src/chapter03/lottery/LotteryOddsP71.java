package chapter03.lottery;
/*
 * ʱ��:2017.3.10
 * ����������ڼ����н��ĸ���
 * */
import java.util.*;

public class LotteryOddsP71 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.print("��Ҫ�����������齱��");
	int k = in.nextInt();
	System.out.print("���ȡ�����������ʲô��");
	int n = in.nextInt();
	/*
	 * һ����˵�����n�������г�ȡk������
	 * ���ʹ�ʽΪ: n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
	 * */
	int lotteryOdds = 1;
	for(int i = 1;i <= k;i++){
		lotteryOdds *= (n-i+1)/i;
	}
	System.out.println("����н�����Ϊ:"+lotteryOdds+" ��֮1 .ף�����!");
	in.close();
}
}
