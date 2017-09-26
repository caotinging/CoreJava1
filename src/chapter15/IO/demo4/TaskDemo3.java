package chapter15.IO.demo4;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * java写一个程序，实现从文件中读出文件内容，并将其打印在屏幕当中，并标注上行号
 * @author caoting
 *
 */

public class TaskDemo3 {
	public static void main(String[] args) throws IOException {
		//利用BufferedReader的子类LineNumberReader
		LineNumberReader lnr = new LineNumberReader(new FileReader("G:\\count.txt"));
		
		String str = null;
		while((str = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() +"  " + str);
		}
		
		lnr.close();
	}
}
