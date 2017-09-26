package chapter15.IO.demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Provide {
	public List<Goods> pList = new ArrayList<Goods>();
	public final ReentrantLock plock = new ReentrantLock();
	
	public Provide() {
		pList.add(new Goods("小米", 1000, 2000));
		pList.add(new Goods("魅族", 1000, 1000));
		pList.add(new Goods("苹果", 1000, 6000));
	}
}
