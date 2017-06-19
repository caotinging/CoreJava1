package chapter05.reflection;

import java.util.*;

/*
 * This program demonstrates the Integer wrapper
 * @version 1.7.0_80 2017/3/28
 * @author CaoTing
 */

public class IntegerTest {
	public static void main (String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);//0
		list.add(5);//1
		list.set(1,6);
		Integer i = list.get(1);
		list.add(18);//2
		list.add(12);//3
		Integer i1 = list.remove(2);
		System.out.println("get(1) = "+i+" delete = "+i1);
		list.set(1,(Triple(list.get(1))));	
		System.out.println("list.get(1) = "+list.get(1));
	}
	public static Integer Triple (Integer x) {
			x = x*4;
			return x;
		}
}
