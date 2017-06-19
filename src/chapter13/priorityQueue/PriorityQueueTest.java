package chapter13.priorityQueue;

import java.util.*;
/**
 * ����ඨ����һ�����ȼ�����
 * ������ṩComparator�Ļ������ȶ�����Ԫ��Ĭ�ϰ���Ȼ˳�����У�
 * Ҳ��������Ĭ����С���ڶ���ͷ���ַ������ֵ������С�
 * @version 1.01 207/5/24
 * @author caoting
 */
public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
		pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
		pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
		pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3));
		pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22));
		
		System.out.println("Iterating over elements...");
		for(GregorianCalendar date : pq) {
			System.out.println(date.get(Calendar.YEAR));
		}
		System.out.println("Removing elements...");
		while(!pq.isEmpty()) {
			System.out.println(pq.remove().get(Calendar.YEAR));
//			���remove()������PriorityQueue���java.util.AbstractQueue�̳����� public E remove()
//			PriorityQueue������remove������public boolean remove(Object o)���� 
//			�Ӹö�����ɾ��ָ��Ԫ�صĵ���ʵ����������ڣ�ע�ⷵ��ֵ
		}
	}
}
