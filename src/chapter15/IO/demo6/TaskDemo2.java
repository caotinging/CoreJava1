package chapter15.IO.demo6;


/**
 * 某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票,假设公司有100个员工,
 * 利用多线程模拟年会入场过程,
	并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印格式如下：
	编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是: [17, 24, 29, 30, 31, 32, 07]
	编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: [06, 11, 14, 22, 29, 32, 15]
	//.....
	从后门入场的员工总共: 13 位员工
	从前门入场的员工总共: 87 位员工
 * @author caoting
 *
 */

public class TaskDemo2 {
	public static void main(String[] args) {
		DoorPool door = new DoorPool();
		Thread t1 = new Thread(door, "前门");
		Thread t2 = new Thread(door, "后门");
		
		t1.start();
		t2.start();
	}
}
