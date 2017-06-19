package chapter14.unsynch;

/**
 * 程序无法自动停止 只能使用ctrl+C退出程序
 * @version 1.8 2017/6/1
 * @author caoting
 */
public class UnsynchBankTest {
	
	private static final int DEFAULT_SIZE = 100;
	private static final double DEFAULT_BALANCE = 1000;
	
	public static void main(String[] args) {
		Bank bank = new Bank(DEFAULT_SIZE, DEFAULT_BALANCE);
		
		int i;
//		每个账户使用一个独立的进程 
		for(i = 0; i < DEFAULT_SIZE; i++) {
			BankRunnable b = new BankRunnable(bank, i, DEFAULT_BALANCE);
			Thread t = new Thread(b);
			t.start();
		}
	}
}
