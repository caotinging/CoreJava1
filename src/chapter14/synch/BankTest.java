package chapter14.synch;

public class BankTest {
	private static final int DEFAULT_SIZE = 100;
	private static final double DEFAULT_BALANCE = 1000;
	
	public static void main(String[] args) {
		BankCopy bank = new BankCopy(DEFAULT_SIZE, DEFAULT_BALANCE);
		
		int i;
//		ÿ���˻�ʹ��һ�������Ľ��� 
		for(i = 0; i < DEFAULT_SIZE; i++) {
			BankRunnable b = new BankRunnable(bank, i, DEFAULT_BALANCE);
			Thread t = new Thread(b);
			t.start();
		}
	}
}
