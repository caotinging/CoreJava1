package chapter03.firstSample;

import java.util.Date;
public class DateP59 {
public static void main(String[] args){
	System.out.printf("%1$s %2$tB %2$te, %2$tY\n","Due Date:",new Date());
	//$�Ƕ�ǰ������������и�ʽ�������%1$��һ��������%2$�ڶ�������
	System.out.printf("%1$s",new Date());
}
}
