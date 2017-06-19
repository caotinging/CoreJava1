package chapter05.enums;

import java.util.*;

/*
 * This program demonstrates enumerated types
 * @version 1.7.0_80 2017/3/29
 * @author CaoTing
 */

public class EnumTest {
	public static void main (String[] args) {
		//@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a size: ( SMALL , MEDIUM , LARGE, EXTRA_LARGE )");
		String input = in.next().toUpperCase();
		//toUpperCase�����ǰ��ַ����е�����Сд��ĸת���ɴ�д��ĸtoLowerCase���෴
		Size size = Enum.valueOf(Size.class, input);
		System.out.print("Size = "+size);
		System.out.println("Abbreviation = "+size.getAbbreviation());
		if(size == Size.EXTRA_LARGE)
			System.out.println("Good job--you paid attention to the _.");
		in.close();
	}
}

enum Size {
	SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
	//("") ��Ҫһ��˽�еĹ�����
	//����ö���������Ϣ���Ʋ�OneNote
	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	private String abbreviation;
}
