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
	 * @param from 要转出的账户
	 * @param to 要转入的账户
	 * @param amount 转账金额
	 */
	public void transfer(int from, int to, double amount) {
		if(amount > account[from]) return;
		
		System.out.print(Thread.currentThread());
		account[from] -= amount;
		System.out.printf(" %10.2f 金额由账户 %d 转至 %d", amount, from, to);
		account[to] += amount;
		System.out.printf(" 当前银行总金额 : %10.2f%n", getTotalBalance());
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
