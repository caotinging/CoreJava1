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
				if(s.equals("ǰ��")) {
					frontNum++;
					/*try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					synchronized (this) {
						System.out.print("���Ϊ��"+person+"�ĳ�Ա��"+s+"�볡���õ���˫ɫ���Ʊ����Ϊ��");
						getNum();
					}
					
				}
				if(s.equals("����")) {
					backNum++;
					/*try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					synchronized (this) {
						System.out.print("���Ϊ��"+person+"�ĳ�Ա��"+s+"�볡���õ���˫ɫ���Ʊ����Ϊ��");
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
				System.out.println("�Ӻ����볡��Ա������Ϊ��"+backNum);
				System.out.println("��ǰ���볡��Ա������Ϊ��"+frontNum);
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