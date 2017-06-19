package chapter14.unsynch;

/**
 * �����ʵ����Runnable�ӿ� ���ݸ�Thread��ʵ���������ת���̶߳���
 * @version 1.8 2017/6/1
 * @author caoting
 *
 */
public class BankRunnable implements Runnable {
	
	private Bank bank;
	private int from;
	private double max_amount;
	private static int DELAY = 10;
	
	public BankRunnable(Bank bank, int from, double amount) {
		this.bank = bank;
		this.from = from;
		max_amount = amount;
	}
	
	public void run() {
		try {
			while(true) {
				int to = (int) (bank.size() * Math.random());
				double amount = max_amount * Math.random();
				bank.transfer(from, to, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		}
		catch(InterruptedException e) {
		}
	}
}
