package chapter15.IO.demo1;

/**
 * �Զ���һ��FileFilter��
 * ���ڻ�ȡ��׺����.java���ļ��������ִ�Сд��
 */
import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		//�����Ŀ¼ֱ�ӷ���
		return pathname.getName().toLowerCase().endsWith(".java");
	}
}
