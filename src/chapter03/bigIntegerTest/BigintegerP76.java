package chapter03.bigIntegerTest;
/*
 * 时间:2017.3.10
 * 改进的抽奖程序数值转换为大数值
 * */
import java.math.*;
import java.util.*;

public class BigintegerP76 {
public static void main(String[] args){
	//@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.print("How many numbers do you need to draw? ");
	int k = in.nextInt();
	System.out.print("What is the highest number you can draw ?");
	int n = in.nextInt();
	BigInteger lotteryOdds = BigInteger.valueOf(1);
	for(int i = 1;i <= k;i++){
		lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
	}//大数值对应的循环体语句
	System.out.println("Your odds are 1 in "+lotteryOdds+". Good Luck !");
	in.close();
	//应该注意关闭输入流否则会出现资源外漏的警告
}
}
