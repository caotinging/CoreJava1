package chapter14.synch;

/**
 * �����ʹ��synchronized�ؼ��ִ�����Lock/Condition ���corejava��һ653
 * @version 1.8 2017/6/3
 * @author caoting
 */
public class BankCopy {
	private final double[] accounts;
	
	public BankCopy(int n, double initial_amount) {
		accounts = new double[n];
		for(int i = 0; i < accounts.length; i++)
			accounts[i] = initial_amount;
	}
	
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
		while(accounts[from] < amount)
			wait();
		System.out.print(Thread.currentThread());
		System.out.printf(" %10.2f ������˻� %d ת���˻� %d", amount, from, to);
		accounts[from] -= amount;
		accounts[to] += amount;
		System.out.printf(" ��ǰ�����ܽ��Ϊ: %10.2f%n", getTotalAmount());
		notifyAll();
	}
	
	public double getTotalAmount() {
		double sum = 0;
		for(double d : accounts) {
			sum += d;
		}
		return sum;
	}
	
	public int size() {
		return accounts.length;
	}
}
