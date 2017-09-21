package chapter15.IO.demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * ���õݹ�����ļ��еĿ�����
 * 		����ʵ��˼��
 * 			�ǿ�Ŀ¼��
 * 					�ļ� --->ֱ�ӿ�����copy��
 * 					Ŀ¼ :
 * 						 if��Ŀ¼  ---> �ж��Ƿ��Ѵ��ڣ������ڵĻ�����mkdirs()��
 * 						 if�ǿ�Ŀ¼��
 * 									�ļ� ---> ֱ�ӿ���
 * 									Ŀ¼:blablabla  ���Կ����ݹ�ṹ��
 * @author caoting
 *
 */

public class TaskDemo2 {
	public static void main(String[] args) {
		//����һ��scanne������ռ������ݣ������ļ���
		Scanner in = new Scanner(System.in);
		System.out.println("������Ҫ���Ƶ��ļ���");
		String begin = in.next();
		System.out.println("������Ŀ���ļ��У�");
		String target = in.next();
		System.out.println("===================");
		
		File bFile = new File(begin);
		//�ж��ļ�·���Ƿ���Ч
		if(bFile==null || target==null) {
			System.out.println("�ļ�·����Ч��");
		}
		else{
			//���ø��Ƶķ���
			copyDir(bFile, target);
		}
		//�ر�in��
		in.close();
	}

	public static void copyDir(File begin, String target) {
		//�ж����ļ�����Ŀ¼
		File targetFile = new File(target);
		
		if(begin.isFile())
			//������ļ������ļ����Ʒ���
			copy(begin, targetFile);
		else {
			//�жϸ�Ŀ¼�Ƿ���� �����ھʹ���
			if(!targetFile.exists())
				targetFile.mkdirs();
			
			File[] files = begin.listFiles();
			for(File f: files) {
				copyDir(f, target+"\\"+f.getName());
			}
		}
	}

	//�ļ����Ʒ���
	public static void copy(File bFile, File tFile) {
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
