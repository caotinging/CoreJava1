package chapter15.IO.demo3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ַ��������ı��ļ�
 * �ַ�����ѯ����Ĭ�ϵı������������GBK
 * FileReader��ȡ����Դ
 * FileWriterд�뵽����Ŀ��
 * @author caoting
 */

public class FileCopyDemo {
	public static void main(String[] args) {
		//����ָ���ļ�·�����ļ�file1(����Դ) file2(����Ŀ��)
		File file1 = new File("G:\\1.txt");
		File file2 = new File("D:\\1.txt");
		//�����ļ����Ʒ���
		copyFile(file1, file2);
		System.out.println("���Ƴɹ���");
	}

	//�����ַ�������ı��ļ�����
	private static void copyFile(File file1, File file2) {
		FileWriter writer = null;
		FileReader reader = null;
		try {
			reader = new FileReader(file1);
			writer = new FileWriter(file2);
			
			int len = -1;
			char[] cs = new char[1024];
			while((len = reader.read(cs)) != -1) {
				writer.write(cs, 0, len);
				writer.flush();//дһ��ˢһ��
			}
		} catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("�ļ�����ʧ��");
		} finally {
			try{
				if(writer!=null) writer.close();
				if(reader!=null) reader.close();
			} catch(IOException ex) {
				throw new RuntimeException("�ͷ���Դʧ��");
			}
		}
	}
}
