package chapter14.unsynch;

/**
 * @version 1.8 2017/6/1
 * @author caoting
 */
public class Bank {
	private final double[] account;
	
	public Bank(int n, double amount) {
		account = new double[n];
		for(int i = 0; i < n; i++) {
			account[i] = amount;
		}
	}
	
	/**
	 * @param from Ҫת�����˻�
	 * @param to Ҫת����˻�
	 * @param amount ת�˽��
	 */
	public void transfer(int from, int to, double amount) {
		if(amount > account[from]) return;
		
		System.out.print(Thread.currentThread());
		account[from] -= amount;
		System.out.printf(" %10.2f ������˻� %d ת�� %d", amount, from, to);
		account[to] += amount;
		System.out.printf(" ��ǰ�����ܽ�� : %10.2f%n", getTotalBalance());
	}
	
	public double getTotalBalance() {
		double sum = 0;
		
		for(double a : account) {
			sum += a;
		}
		return sum;
	}
	
	public int size() {
		return account.length;
	}
}
