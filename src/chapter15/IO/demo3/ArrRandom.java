package chapter15.IO.demo3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrRandom {
	
	private double[] arr = new double[10];
	
	//随机生成一个数组
	public ArrRandom() {
		for(int i = 0; i<10; i++) {
			arr[i] = Math.random()*100;
		}
	}
	
	//把数组中大于10的数字放到list集合中,并打印在控制台
	public List<Double> getBig() {
		List<Double> list = new ArrayList<Double>();
		
		for(int i=0; i<10; i++) {
			if(arr[i] >= 10)
				list.add(arr[i]);
		}
		System.out.println("List集合中的数字如下:");
		ListIterator<Double> it = list.listIterator();
		while(it.hasNext())
			System.out.printf("%8.2f", it.next());
		
		return list;
	}
}
