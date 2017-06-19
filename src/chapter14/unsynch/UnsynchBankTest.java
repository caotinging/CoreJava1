package chapter14.unsynch;

/**
 * �����޷��Զ�ֹͣ ֻ��ʹ��ctrl+C�˳�����
 * @version 1.8 2017/6/1
 * @author caoting
 */
public class UnsynchBankTest {
	
	private static final int DEFAULT_SIZE = 100;
	private static final double DEFAULT_BALANCE = 1000;
	
	public static void main(String[] args) {
		Bank bank = new Bank(DEFAULT_SIZE, DEFAULT_BALANCE);
		
		int i;
//		ÿ���˻�ʹ��һ�������Ľ��� 
		for(i = 0; i < DEFAULT_SIZE; i++) {
			BankRunnable b = new BankRunnable(bank, i, DEFAULT_BALANCE);
			Thread t = new Thread(b);
			t.start();
		}
	}
}
