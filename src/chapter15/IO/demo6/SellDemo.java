package chapter15.IO.demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SellDemo {
	public static void main(String[] args) throws InterruptedException {
		
		Shop s = new Shop();
		Provide p = new Provide();
		
		Thread bt1 = new Thread(new Buyer(s));
		Thread bt2 = new Thread(new Buyer(s));
		Thread bt3 = new Thread(new Buyer(s));
		Thread bt4 = new Thread(new Buyer(s));
		Thread bt5 = new Thread(new Buyer(s));
		
		Thread st2 = new Thread(new Seller(p, s));
		Thread st3 = new Thread(new Seller(p, s));
		
		int i = 0;
		
		ExecutorService ex1 = Executors.newFixedThreadPool(3);
		ExecutorService ex2 = Executors.newFixedThreadPool(3);
		while(true) {
			i++;
			if(i > 20)
				break;
			ex1.submit(st2);
			ex1.submit(st3);
			
			ex2.submit(bt1);
			ex2.submit(bt2);
			ex2.submit(bt3);
			ex2.submit(bt4);
			ex2.submit(bt5);
		}
		
	/*	Timer t = new Timer();
		t.schedule(new Time(), 10);*/
		ex1.shutdown();
		ex2.shutdown();
		
		Thread.sleep(600);
		System.out.println("===============");
		s.getProfit();
	}
}
/*class Time extends TimerTask {
	
	public void run() {
		SellDemo.flag = false;
	}
	
}*/