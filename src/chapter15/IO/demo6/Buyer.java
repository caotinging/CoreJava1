package chapter15.IO.demo6;

import java.util.concurrent.ThreadLocalRandom;

public class Buyer implements Runnable {
	private Shop s;
	
	public Buyer(Shop s) {
		this.s = s;
	}
	
	public void run() {
		buyGoods();
	}
	
	public void buyGoods() {
		s.slock.lock();
		try {
			int n = ThreadLocalRandom.current().nextInt(3)+1;
			Goods good = s.sList.get(n);
			if(good.count <= 0 )
				return;
			s.sList.get(n).count--;
			System.out.println(Thread.currentThread().getName()+" ¹ºÂòÁË "+good.name);
			s.setbMoney(good.cost);
			
		}finally{
			s.slock.unlock();
		}
	}
}
