package chapter03.lottery;

import java.util.*;

/*
 * ʱ�䣺2017.3.13
 * �ó����ǳ齱����ĸĽ�����
 * ���齱����������������ֲ����ظ�
 * �����Ǽ���齱�н�����*/

public class LotteryDrawingP83 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.print("�˴γ齱һ���������֣�");
	int n = in.nextInt();
	System.out.print("�˴ο�������һ��������");
	int k = in.nextInt();
	int[] number = new int[n];
	int[] result = new int[k];
	//�������鴴�����
	for(int i = 0;i < number.length;i++)
		number[i] = i+1;
	//���濪ʼ��ȡ�н����ֵ��±� ����Math.random�������鱾82ҳ
	for(int i = 0;i < result.length;i++){
		int r = (int)(Math.random()*n);
		result[i] = number[r];
		number[r] = number[n-1];
		n--;
	}//����������Ϊ�˲���ȡ�ظ�����
	Arrays.sort(result);//��result����Ԫ�ؿ�������
	System.out.println("�˴�������������Ϊ:");
	for(int i:result)
		System.out.print(" "+i);
	System.out.println();
	System.out.println("ף�����ˣ�");
	in.close();
}
}
