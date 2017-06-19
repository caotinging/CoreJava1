package chapter03.lottery;

import java.util.*;

/*
 * 时间：2017.3.13
 * 该程序是抽奖程序的改进方案
 * 将抽奖数字排序输出，数字不会重复
 * 而不是计算抽奖中奖概率*/

public class LotteryDrawingP83 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.print("此次抽奖一共多少数字？");
	int n = in.nextInt();
	System.out.print("此次开奖数字一共几个？");
	int k = in.nextInt();
	int[] number = new int[n];
	int[] result = new int[k];
	//两个数组创建完毕
	for(int i = 0;i < number.length;i++)
		number[i] = i+1;
	//下面开始抽取中奖数字的下标 关于Math.random方法在书本82页
	for(int i = 0;i < result.length;i++){
		int r = (int)(Math.random()*n);
		result[i] = number[r];
		number[r] = number[n-1];
		n--;
	}//这种做法是为了不抽取重复数字
	Arrays.sort(result);//对result数组元素快速排序
	System.out.println("此次您的幸运数字为:");
	for(int i:result)
		System.out.print(" "+i);
	System.out.println();
	System.out.println("祝您好运！");
	in.close();
}
}
