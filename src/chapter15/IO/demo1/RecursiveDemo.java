package chapter15.IO.demo1;

/**
 * 递归方法中需要明白的点
 * 1.该方法的主要作用，我调用这个方法的目的必须明确
 * 2.递归的次数不能过多否则会造成内存溢出
 * 3.构造方法禁止递归
 * @author caoting
 *
 */

public class RecursiveDemo {
	public static void main(String[] args) {
//		测试几个经典的递归例子
		System.out.println(fun_1(12));
		System.out.println(fun_2(5));
		System.out.println(fun_3(100));
	}
		
	/* 利用递归 计算斐波那契数列
	 * 首先明确方法的目的：计算第n个数的值  之所以要自己调用自己
	 * 要是因为我的下一个目的依旧是计算第n-1个数的值
	 * F(n) = F(n-1) + F(n-2)
	 */
	public static int fun_1(int n) {
		if(n < 3) 
			return 1;
		return fun_1(n-1) + fun_1(n-2);
	}
	
	/*
	 * 利用递归 计算5的阶乘：5!
	 */
	public static int fun_2(int n) {
		if(n <= 1)
			return 1;
		return n * fun_2(n-1);
	}
	
	/*
	 * 利用递归 计算1~100累加
	 */
	public static int fun_3(int n) {
		if(n <= 1)
			return 1;
		return n + fun_3(n-1);
	}
}
