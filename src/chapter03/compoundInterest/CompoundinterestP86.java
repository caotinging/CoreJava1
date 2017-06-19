package chapter03.compoundInterest;

/*
 * 时间:2017.3.13
 * 一维数组interest用于存储利率
 * 二维数组balances一维表示年二维表示利率
 * */

public class CompoundinterestP86 {
public static void main(String[] args){
	final double STARTRATE = 10;
	final int NRATES = 6;
	final int NYEARS = 10;
	//final变量是常量 常量的值不能再改变
	double[] interestRate = new double[NRATES];
	for(int j = 0;j < interestRate.length;j++)
		interestRate[j] = (STARTRATE + j)/100;
	//利率从10%到15%
	double[][] balances = new double[NYEARS][NRATES];
	//创建一个二维数组
	for(int j = 0;j < balances[0].length;j++)
		balances[0][j] = 10000;
	//用初始余额初始化该二维数组的第一行
	for(int i = 1;i < balances.length;i++)
		for(int j = 0;j < balances[i].length;j++){
			double Oldbalances = balances[i-1][j];//每年更新的本金
			double interest = Oldbalances*interestRate[j];//该年的利息
			balances[i][j] = Oldbalances + interest;//本息和
			//System.out.println("i的值:"+i);
		}
	for(int j = 0;j < interestRate.length;j++)
		System.out.printf("%9.0f%%",100 * interestRate[j]);
	System.out.println();
	for(double[] row:balances){
		for(double b:row)
			System.out.printf("%10.2f",b);
		System.out.println();
	}
}
}
