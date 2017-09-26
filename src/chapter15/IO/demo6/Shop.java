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
		sList.add(new Goods("С��", 5, 2500));
		sList.add(new Goods("����", 5, 2000));
		sList.add(new Goods("ƻ��", 2,7000));
		sMoney = 5*2000+5*1500+2*6500;//ԭ��
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
			System.out.println("ӯ��Ϊ��"+(bMoney-sMoney)+" Ԫ����ϲ��");
		} else if(bMoney == sMoney) {
			System.out.println("û��ӯ��Ҳû�ÿ���Ŷ");
		} else {
			System.out.println("���ź���������"+(sMoney-bMoney)+" Ԫ��");
		}
	}
}
