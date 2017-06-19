package chapter03.firstSample;

import java.util.Date;
public class DateP59 {
public static void main(String[] args){
	System.out.printf("%1$s %2$tB %2$te, %2$tY\n","Due Date:",new Date());
	//$是对前面给定参数进行格式化输出，%1$第一个参数，%2$第二个参数
	System.out.printf("%1$s",new Date());
}
}
