package chapter03.lottery;

/*
 * 时间:2017.3.13
 * 创建不规则多维数组
 * */

public class LotteryArrayP89 {
public static void main(String[] args){
	final int NMAX = 10;
	int[][] odds = new int[NMAX+1][];
	for(int n = 0;n<= NMAX;n++){
		odds[n] = new int[n+1];//创建一个不规则数组
	}
	for(int n = 0;n < odds.length;n++)
		for(int k = 0;k < odds[n].length;k++){
			int lotteryodds = 1;
			for(int i = 1;i <= k;i++)
				lotteryodds = lotteryodds * (n-i+1)/i;
			odds[n][k] = lotteryodds;
		}
	for(int[] row:odds){
		for(int odd:row)
			System.out.printf("%4d",odd);
		System.out.println();
		}
}
}
