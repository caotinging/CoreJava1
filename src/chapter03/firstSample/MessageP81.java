package chapter03.firstSample;

//import java.util.Arrays;

/*
 * 时间:2017.3.13
 * 该程序用于检测主方法命令行参数
 * args字符串数组*/
public class MessageP81 {
public static void main(String[] args){
	if(args[0].equals("-h"))
		System.out.print("Hello,");
	//如果命令行第一个参数为-h输出hello
	else if(args[0].equals("-g"))
		System.out.print("Goodbye,");
	//如果命令行第一个参数是-g输出Goodbye
	for(String ml:args)
		System.out.print(" "+ml);
	//System.out.print(Arrays.toString(args));
	//Arrays.toString()返回一个包含数组元素的字符串，这些元素放置在括号内用逗号分隔
	//关于这两种输出方法在书本80页for each循环处
	System.out.println("!");
	//运行此程序需要输入命令行参数，先运行配置自变量程序自变量输入参数运行
}
}
