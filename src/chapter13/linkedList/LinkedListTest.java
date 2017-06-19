package chapter13.linkedList;

import java.util.*;

/**
 * @version 1.8 2017/5/22
 * @author caoting
 */
public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> a = new LinkedList<>();
		a.add("Amy");
		a.add("Cral");
		a.add("Erica");
		
		LinkedList<String> b = new LinkedList<>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		while(bIter.hasNext()){//这里已经使用b的迭代器遍历了b链表
			if(aIter.hasNext())
				aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println(a);

		//这里需要重新初始化b链表的迭代器
		bIter = b.iterator();
		while(bIter.hasNext()) {
			bIter.next();
			if(bIter.hasNext()){
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
	}
}