package chapter15.IO.demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoorPool implements Runnable {

	private int frontNum = 0;
	private int backNum = 0;
	private static int person = 100;
	
	public void run() {
		while(true) {
			String s = Thread.currentThread().getName();
			if(person < 0)
				return;
			if(person > 0) {
				if(s.equals("前门")) {
					frontNum++;
					/*try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					synchronized (this) {
						System.out.print("编号为："+person+"的成员从"+s+"入场！拿到的双色球彩票号码为：");
						getNum();
					}
					
				}
				if(s.equals("后门")) {
					backNum++;
					/*try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					synchronized (this) {
						System.out.print("编号为："+person+"的成员从"+s+"入场！拿到的双色球彩票号码为：");
						getNum();
					}
				}
				synchronized (this) {
					person--;
				}
			}
			if(person == 1){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("从后门入场的员工总数为："+backNum);
				System.out.println("从前门入场的员工总数为："+frontNum);
				break;
			}
		}
	}
	
	public void getNum() {
		List<Integer> list = new ArrayList<Integer>();
		while(list.size() <= 7) {
			list.add(new Random().nextInt(100));
		}
		System.out.println(list);
	}
}