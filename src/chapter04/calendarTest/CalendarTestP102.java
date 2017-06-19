package chapter04.calendarTest;

/*
 * ʱ��:2017.3.15
 * �ó������ڴ�ӡ����
 * */

import java.text.DateFormatSymbols;
import java.util.*;

public class CalendarTestP102 {
public static void main(String[] args){
	GregorianCalendar d = new GregorianCalendar();
	//����һ�������������õ�ʱ��ʱ�����ڳ�ʼ��
	int today = d.get(Calendar.DAY_OF_MONTH);
	int month = d.get(Calendar.MONTH);
	//��get������ȡ��ʱ���պ���
	d.set(Calendar.DAY_OF_MONTH,1);
	int weekday = d.get(Calendar.DAY_OF_WEEK);
	//��d��Ϊ��ǰ�µĵ�һ�첢�õ���һ�������ڼ�;
	int firstofweek = d.getFirstDayOfWeek();
	int indent = 0;
	//firstofweekΪ���ص����ڿ�ʼindent���ڼ�����������
	while(weekday != firstofweek){
		indent++;
		d.add(Calendar.DAY_OF_MONTH,-1);
		weekday = d.get(Calendar.DAY_OF_WEEK);
	}
	//�����԰�����ϰ��˳��������������ڼ�����
	String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
	do{
		System.out.printf("%4s",weekdayNames[weekday]);
		d.add(Calendar.DAY_OF_MONTH,1);
		weekday = d.get(Calendar.DAY_OF_WEEK);
	}while(weekday != firstofweek);
	System.out.println();
	//���濪ʼ������������ڲ���
	d.set(Calendar.DAY_OF_MONTH,1);
	do
	{
		for(;indent > 0;indent--)
			System.out.print(" "+" "+" "+" "+" "+" ");//����
		if(d.get(Calendar.DAY_OF_WEEK) == firstofweek)
			System.out.println();//ÿ�����ڵĵ�һ�컻��
		System.out.printf("%5s", d.get(Calendar.DAY_OF_MONTH));
		if(d.get(Calendar.DAY_OF_MONTH) == today)
			System.out.print("*");
		else System.out.print(" ");//���ǰ��ҵĸ��ҵ��� ����˶�һ��*�ַ������ΰ�
		d.add(Calendar.DAY_OF_MONTH, 1);
	}while(d.get(Calendar.MONTH) == month);//ֻҪ���Ǳ��¾ͼ���
	System.out.println();
	System.out.printf("\n%s",new Date());
}
}

