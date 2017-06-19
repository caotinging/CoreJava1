package chapter03.lottery;
/*
 * 时间:2017.3.10
 * 这个程序用于计算中奖的概率
 * */
import java.util.*;

public class LotteryOddsP71 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.print("你要多少数字来抽奖？");
	int k = in.nextInt();
	System.out.print("你抽取的最高数字是什么？");
	int n = in.nextInt();
	/*
	 * 一般来说如果从n个数字中抽取k个数字
	 * 概率公式为: n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
	 * */
	int lotteryOdds = 1;
	for(int i = 1;i <= k;i++){
		lotteryOdds *= (n-i+1)/i;
	}
	System.out.println("你的中奖几率为:"+lotteryOdds+" 分之1 .祝你好运!");
	in.close();
}
}
