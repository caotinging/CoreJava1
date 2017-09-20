package chapter15.IO.demo1;

/**
 * �ݹ鷽������Ҫ���׵ĵ�
 * 1.�÷�������Ҫ���ã��ҵ������������Ŀ�ı�����ȷ
 * 2.�ݹ�Ĵ������ܹ�����������ڴ����
 * 3.���췽����ֹ�ݹ�
 * @author caoting
 *
 */

public class RecursiveDemo {
	public static void main(String[] args) {
//		���Լ�������ĵݹ�����
		System.out.println(fun_1(12));
		System.out.println(fun_2(5));
		System.out.println(fun_3(100));
	}
		
	/* ���õݹ� ����쳲���������
	 * ������ȷ������Ŀ�ģ������n������ֵ  ֮����Ҫ�Լ������Լ�
	 * Ҫ����Ϊ�ҵ���һ��Ŀ�������Ǽ����n-1������ֵ
	 * F(n) = F(n-1) + F(n-2)
	 */
	public static int fun_1(int n) {
		if(n < 3) 
			return 1;
		return fun_1(n-1) + fun_1(n-2);
	}
	
	/*
	 * ���õݹ� ����5�Ľ׳ˣ�5!
	 */
	public static int fun_2(int n) {
		if(n <= 1)
			return 1;
		return n * fun_2(n-1);
	}
	
	/*
	 * ���õݹ� ����1~100�ۼ�
	 */
	public static int fun_3(int n) {
		if(n <= 1)
			return 1;
		return n + fun_3(n-1);
	}
}
