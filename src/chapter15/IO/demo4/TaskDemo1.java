package chapter15.IO.demo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流和高效流
 * 将GBK的文本文件利用转换流和高效流复制一份UTF-8的文件
 * @author caoting
 * 步骤分析：
 * 		· 创建字节输入流，传递编码名称初始化转换流
 * 		· 利用高效流包装转换流
 * 		· 利用高效缓冲流的readLine和write，newLine等方法完成文件复制
 * 
 */

public class TaskDemo1 {
	public static void main(String[] args) throws IOException {
		File src = new File("G:\\1.txt");
		File desc = new File("G:\\copy\\1.txt");
		//调用复制方法
		copy(src, desc);
		
		System.out.println("复制成功");
	}
	
	public static void copy(File src, File desc) throws IOException {
		//转换流
		InputStreamReader reader = new InputStreamReader(new FileInputStream(src), "GBK");
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(desc), "UTF-8");
		
		//高效缓冲流
		BufferedReader br = new BufferedReader(reader);
		BufferedWriter bw = new BufferedWriter(writer);
		
		//进行复制转换编码操作
		String str = null;
		while((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		
		//关闭流资源
		br.close();
		bw.close();
	}
}
