package chapter15.IO.demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * �Ӽ��̽��������ļ�·���������ļ�����
 * @author caoting
 *
 */
public class TaskDemo1 {
	public static void main(String[] args) {
		//����һ��scanne������ռ������ݣ������ļ���
		Scanner in = new Scanner(System.in);
		System.out.println("������Ҫ���Ƶ��ļ���");
		String begin = in.next();
		System.out.println("������Ŀ���ļ��У�");
		String target = in.next();
		System.out.println("===================");
		//���ø��Ƶķ���
		copyDir(begin, target);
		//�ر�in��
		in.close();
	}

	public static void copyDir(String begin, String target) {
		File bFile = new File(begin);
		File tFile = new File(target);
		//�ж��ļ�·���Ƿ���Ч
		if(bFile==null || tFile==null) {
			System.out.println("�ļ�·����Ч��");
			return;
		}
		//����һ���ֽ���������һ���ֽ������
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		//����IO�쳣
		try {
			fileInputStream = new FileInputStream(bFile);
			fileOutputStream = new FileOutputStream(tFile);
			//����һ���ֽ��������ڻ���
			byte[] bytes = new byte[1024];
			//����whileѭ�����и���
			int len = 0;
			while((len = fileInputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, len);
			}
			
		}catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("�ļ�����ʧ��");
		}finally {
			//�ر���Ҳ����Ҫ��׽���쳣���ȿ���أ��ȹ������
			//�ر���֮ǰ���ж��Ƿ�Ϊnull
			try {
				if(fileOutputStream != null)
					fileOutputStream.close();
			}catch(IOException e) {
				throw new RuntimeException("FileOutPutStream���ر�ʧ�ܣ�");
			}finally {
				try{
					if(fileInputStream != null)
						fileInputStream.close();
				}catch(IOException e) {
					throw new RuntimeException("FileInputStream���ر�ʧ�ܣ�");
				}
			}
		}
	}
}
