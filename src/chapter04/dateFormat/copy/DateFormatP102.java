package chapter04.dateFormat.copy;

/*
 * 时间:2017.3.14
 * 此程序用于检测一个没弄懂的学习疑问
 * */
import java.text.DateFormatSymbols;

public class DateFormatP102 {
public static void main(String[] args){
	String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
	//最后的最后我终于明白了
	/*
	 *	String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
	 *是把weekdayNames初始化成下标1到7表示为星期一到星期日
	 * */
	//weekdayNames[0] = "aaa";
	//weekdayNames[1] = "sunday";
	System.out.println(weekdayNames[0]+weekdayNames[1]+weekdayNames[2]);
}
}
