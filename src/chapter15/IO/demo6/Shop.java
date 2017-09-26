package chapter15.IO.demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Shop {
	
	public List<Goods> sList = new ArrayList<Goods>(3);
	private double sMoney;
	private double bMoney;
	public final ReentrantLock slock = new ReentrantLock();
	
	public Shop() {
		sList.add(new Goods("小米", 5, 2500));
		sList.add(new Goods("魅族", 5, 2000));
		sList.add(new Goods("苹果", 2,7000));
		sMoney = 5*2000+5*1500+2*6500;//原价
		bMoney = 0;
	}
	
	public double getsMoney() {
		return sMoney;
	}
	public void setsMoney(double Money) {
		sMoney = sMoney + Money;
	}
	public double getbMoney() {
		return bMoney;
	}
	public void setbMoney(double Money) {
		bMoney = bMoney + Money;
	}
	
	public void getProfit() {
		if(bMoney > sMoney) {
			System.out.println("盈利为："+(bMoney-sMoney)+" 元！恭喜！");
		} else if(bMoney == sMoney) {
			System.out.println("没有盈利也没用亏损哦");
		} else {
			System.out.println("很遗憾！亏损了"+(sMoney-bMoney)+" 元！");
		}
	}
}
