package chapter13.priorityQueue;

import java.util.*;
/**
 * 这个类定义了一个优先级队列
 * 如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，
 * 也就是数字默认是小的在队列头，字符串则按字典序排列。
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
//			这个remove()方法是PriorityQueue类从java.util.AbstractQueue继承来的 public E remove()
//			PriorityQueue类重载remove方法有public boolean remove(Object o)方法 
//			从该队列中删除指定元素的单个实例（如果存在）注意返回值
		}
	}
}
