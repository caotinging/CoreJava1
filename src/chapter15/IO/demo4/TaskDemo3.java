package chapter15.IO.demo4;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * javaдһ������ʵ�ִ��ļ��ж����ļ����ݣ��������ӡ����Ļ���У�����ע���к�
 * @author caoting
 *
 */

public class TaskDemo3 {
	public static void main(String[] args) throws IOException {
		//����BufferedReader������LineNumberReader
		LineNumberReader lnr = new LineNumberReader(new FileReader("G:\\count.txt"));
		
		String str = null;
		while((str = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() +"  " + str);
		}
		
		lnr.close();
	}
}
