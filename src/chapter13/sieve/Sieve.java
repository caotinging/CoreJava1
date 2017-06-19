package chapter13.sieve;

import java.util.*;

/**
 * �����������ɸ���㷨 ��Ҫ���ڲ���λ���� ���Ա����������
 * @version 1.21 2017/5/28
 * @author caoting
 */
public class Sieve {
	public static void main(String[] args) {
		int n = 2000000;
		long start = System.currentTimeMillis();
		BitSet b = new BitSet(n + 1);
		int count = 0;
		int i;
		for(i = 2; i <= n; i++)
			b.set(i);
		i = 2;
		
		while(i * i <= n) {
			if(b.get(i)) {
				count ++;
				int k = 2 * i;
				while(k <= n) {
					b.clear(k);
					k += i;
				}
			}
			i ++;
		}
		
		while(i <= n){
			if(b.get(i))
				count ++;
			i ++;
		}
		long end = System.currentTimeMillis();
		System.out.println(count + " ������");
		System.out.println("���� " + (end - start) + " ����");
	}
}
