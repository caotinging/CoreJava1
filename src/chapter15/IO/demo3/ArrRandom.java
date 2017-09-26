package chapter15.IO.demo3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrRandom {
	
	private double[] arr = new double[10];
	
	//�������һ������
	public ArrRandom() {
		for(int i = 0; i<10; i++) {
			arr[i] = Math.random()*100;
		}
	}
	
	//�������д���10�����ַŵ�list������,����ӡ�ڿ���̨
	public List<Double> getBig() {
		List<Double> list = new ArrayList<Double>();
		
		for(int i=0; i<10; i++) {
			if(arr[i] >= 10)
				list.add(arr[i]);
		}
		System.out.println("List�����е���������:");
		ListIterator<Double> it = list.listIterator();
		while(it.hasNext())
			System.out.printf("%8.2f", it.next());
		
		return list;
	}
}
