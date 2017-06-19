package chapter14.synch;

import java.util.concurrent.locks.*;

/**
 * 这个类对unsynch包中的Bank类进行了相关优化  运用了锁和与其相关的条件对象同步并行线程的共享对象
 * @version 1.8 2017/6/2
 * @author caoting
 */
public class Bank {
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;
	
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for(int i = 0; i < n; i++) {
			accounts[i] = initialBalance;
		}
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	
	public void transfer(int from, int to, double amount) throws InterruptedException {
		bankLock.lock();
		try {
			while(accounts[from] < amount)
				sufficientFunds.await();
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f 金额由账户 %d 转至 %d ", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" 转账后总金额为 : %10.2f%n", getTotalBalance());
			sufficientFunds.signalAll();
		}
		finally {
			bankLock.unlock();
		}
	}
	
	public double getTotalBalance() {
		bankLock.lock();
		try{
		double sum = 0;
		for(double a : accounts) {
			sum += a;
		}
		return sum; }
		finally {
			bankLock.unlock();
		}
	}
	
	public int size() {
		return accounts.length;
	}
}
