package chapter15.IO.demo6;

import java.util.Random;

/**
 * @Param arr: ���ڳ齱������
 * @param name: ���ڸ����̵߳�����
 * @author caoting
 *
 */

public class LuckyPool implements Runnable {
	private int[] arr = {10, 5, 20, 100, 200, 500, 800, 2, 80, 300};
	private String name;
	
	public LuckyPool(String name) {
		this.name = name;
	}

	public void run() {
		Thread.currentThread().setName(name);
		for(int i=0; i<10; i++) {
			int j = new Random().nextInt(10);
			System.out.println(Thread.currentThread().getName()+"  �ֲ�����һ��"+arr[j]+"Ԫ�����󽱣�");
		}
	}
}
