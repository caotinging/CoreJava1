package chapter15.IO.demo0;

import java.io.File;

/**
 * java.io.File:将操作系统中的文件，文件夹，路径封装成File对象
 * 提供方法操作系统中的内容
 * 
 * 文件：File 目录：Directory 路径：Path
 * @author caoting
 */

public class FileDemo0 {
	public static void main(String[] args) {
//		File的静态成员变量
//		windows操作系统下的默认名称分隔符: \  Linux为：/
		String separator = File.separator; 
		System.out.println(separator);
		
//		windows操作系统下的默认路径分隔符:  ;（分号）Linux为： : （冒号）
		separator = File.pathSeparator;
		System.out.println(separator);
		/**
		 * 注意File静态成员分隔符的作用可以实现跨平台
		 */
	}
}
