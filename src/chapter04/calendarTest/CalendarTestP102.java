package chapter04.calendarTest;

/*
 * 时间:2017.3.15
 * 该程序用于打印日历
 * */

import java.text.DateFormatSymbols;
import java.util.*;

public class CalendarTestP102 {
public static void main(String[] args){
	GregorianCalendar d = new GregorianCalendar();
	//构造一个日历对象并且用当时的时间日期初始化
	int today = d.get(Calendar.DAY_OF_MONTH);
	int month = d.get(Calendar.MONTH);
	//用get方法获取当时的日和月
	d.set(Calendar.DAY_OF_MONTH,1);
	int weekday = d.get(Calendar.DAY_OF_WEEK);
	//将d设为当前月的第一天并得到第一天是星期几;
	int firstofweek = d.getFirstDayOfWeek();
	int indent = 0;
	//firstofweek为当地的星期开始indent用于计算缩进距离
	while(weekday != firstofweek){
		indent++;
		d.add(Calendar.DAY_OF_MONTH,-1);
		weekday = d.get(Calendar.DAY_OF_WEEK);
	}
	//随后可以按当地习惯顺序输出日历的星期几名称
	String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
	do{
		System.out.printf("%4s",weekdayNames[weekday]);
		d.add(Calendar.DAY_OF_MONTH,1);
		weekday = d.get(Calendar.DAY_OF_WEEK);
	}while(weekday != firstofweek);
	System.out.println();
	//下面开始输出日历的日期部分
	d.set(Calendar.DAY_OF_MONTH,1);
	do
	{
		for(;indent > 0;indent--)
			System.out.print(" "+" "+" "+" "+" "+" ");//缩进
		if(d.get(Calendar.DAY_OF_WEEK) == firstofweek)
			System.out.println();//每个星期的第一天换行
		System.out.printf("%5s", d.get(Calendar.DAY_OF_MONTH));
		if(d.get(Calendar.DAY_OF_MONTH) == today)
			System.out.print("*");
		else System.out.print(" ");//机智啊我的哥我的天 解决了多一个*字符的尴尬癌
		d.add(Calendar.DAY_OF_MONTH, 1);
	}while(d.get(Calendar.MONTH) == month);//只要还是本月就继续
	System.out.println();
	System.out.printf("\n%s",new Date());
}
}

