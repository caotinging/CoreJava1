package chapter03.lottery;

/*
 * ʱ��:2017.3.13
 * �����������ά����
 * */

public class LotteryArrayP89 {
public static void main(String[] args){
	final int NMAX = 10;
	int[][] odds = new int[NMAX+1][];
	for(int n = 0;n<= NMAX;n++){
		odds[n] = new int[n+1];//����һ������������
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
