package chapter15.IO.demo6;

/**
 * ��һ���齱��,�ó齱���д���˽����Ľ��,�ó齱����һ������int[] arr = {10,5,20,50,100,200,500,800,2,80,300}; 
	���������齱��(�߳�)�����߳����Ʒֱ�Ϊ���齱��1�������齱��2���������arr�����л�ȡ����Ԫ�ز���ӡ�ڿ���̨��,��ʽ����:
	�齱��1 �ֲ�����һ�� 10 Ԫ��
	�齱��2 �ֲ�����һ�� 100 Ԫ��
	....
 * @author caoting
 *
 */

public class TaskDemo1 {
	public static void main(String[] args) {
		LuckyPool luc1 = new LuckyPool("�齱��1");
		LuckyPool luc2 = new LuckyPool("�齱��2");
		Thread t1 = new Thread(luc1);
		Thread t2 = new Thread(luc2);
		t1.start();
		t2.start();
	}
}
