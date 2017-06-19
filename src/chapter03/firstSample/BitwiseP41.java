package chapter03.firstSample;
/*
 * 关于java中<< >> >>>
 * 位运算符的使用示例
 * 日期:2017.3.2*/
public class BitwiseP41 {
   public static void main(String[] args){
    int number = 10;
    printinfo(number);//输出原始数据
    number = number << 1;
    printinfo(number);//左移一位相当于乘以2
    number = number >> 1;
    printinfo(number);//右移一位相当于除以2
   }
   private static void printinfo(int num){
	   System.out.println(Integer.toBinaryString(num));
	   System.out.println("number = "+num);
   }
}
/*对于：>>>无符号右移，忽略符号位，空位都以0补齐
value >>> n     --   n 指定要移位值value 移动的位数。
无符号右移的规则只记住一点：忽略了符号位扩展，0补最高位  无符号右移运算符>>> 只是对32位和64位的值有意义*/
/**附录:十进制和二进制的换算方法
 * 把该十进制数，用二因式分解，取余。 
 * 以235为例，转为二进制 
 * 235除以2得117，余1 
 * 117除以2得58，余1 
 * 58除以2得29，余0 
 * 29除以2得14，余1 
 * 14除以2得7，余0 
 * 7除以2得3，余1 
 * 3除以2得1，余1 
 * 从得到的1开始写起，余数倒排，加在它后面，就可得11101011
 * 把十进制中的小数部份，转为二进制。 
 * 把该小数不断乘2，取整，直至没有小数为止，注意不是所有小数都能转为二进制！ 
 * 以0.75为例， 
 * 0.75剩以2得1.50，取整数1 
 * 0.50剩以2得1，取整数1，顺序取数就可得0.11。　
 *  */
