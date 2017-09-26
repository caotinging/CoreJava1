package chapter15.IO.demo6;

/**
 * 有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300}; 
	创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:
	抽奖箱1 又产生了一个 10 元大奖
	抽奖箱2 又产生了一个 100 元大奖
	....
 * @author caoting
 *
 */

public class TaskDemo1 {
	public static void main(String[] args) {
		LuckyPool luc1 = new LuckyPool("抽奖箱1");
		LuckyPool luc2 = new LuckyPool("抽奖箱2");
		Thread t1 = new Thread(luc1);
		Thread t2 = new Thread(luc2);
		t1.start();
		t2.start();
	}
}
