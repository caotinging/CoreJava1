package chapter04.dateFormat.copy;

/*
 * ʱ��:2017.3.14
 * �˳������ڼ��һ��ûŪ����ѧϰ����
 * */
import java.text.DateFormatSymbols;

public class DateFormatP102 {
public static void main(String[] args){
	String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
	//�������������������
	/*
	 *	String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
	 *�ǰ�weekdayNames��ʼ�����±�1��7��ʾΪ����һ��������
	 * */
	//weekdayNames[0] = "aaa";
	//weekdayNames[1] = "sunday";
	System.out.println(weekdayNames[0]+weekdayNames[1]+weekdayNames[2]);
}
}
