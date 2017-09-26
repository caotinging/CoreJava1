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
 * ת�����͸�Ч��
 * ��GBK���ı��ļ�����ת�����͸�Ч������һ��UTF-8���ļ�
 * @author caoting
 * ���������
 * 		�� �����ֽ������������ݱ������Ƴ�ʼ��ת����
 * 		�� ���ø�Ч����װת����
 * 		�� ���ø�Ч��������readLine��write��newLine�ȷ�������ļ�����
 * 
 */

public class TaskDemo1 {
	public static void main(String[] args) throws IOException {
		File src = new File("G:\\1.txt");
		File desc = new File("G:\\copy\\1.txt");
		//���ø��Ʒ���
		copy(src, desc);
		
		System.out.println("���Ƴɹ�");
	}
	
	public static void copy(File src, File desc) throws IOException {
		//ת����
		InputStreamReader reader = new InputStreamReader(new FileInputStream(src), "GBK");
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(desc), "UTF-8");
		
		//��Ч������
		BufferedReader br = new BufferedReader(reader);
		BufferedWriter bw = new BufferedWriter(writer);
		
		//���и���ת���������
		String str = null;
		while((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		
		//�ر�����Դ
		br.close();
		bw.close();
	}
}
