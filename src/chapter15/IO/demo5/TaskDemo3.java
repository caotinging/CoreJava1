package chapter15.IO.demo5;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/**
 * ��ȡָ��Ŀ¼����Ŀ¼������txt�ļ��ĸ�����������Щtxt�ļ����Ƶ�D��������Ŀ¼
 * ���ù��������
 * @author caoting
 *
 */

public class TaskDemo3 {
	public static void main(String[] args) {
		Collection<File> list = getTxt();
		System.out.println(list);
	}
	
	public static  Collection<File> getTxt() {
		//��ȡָ��Ŀ¼����Ŀ¼�µ�����txt�ļ�
		Collection<File> list = FileUtils.listFiles(new File("G:"), new MyFilterForTxt("txt"), TrueFileFilter.INSTANCE);
		return list;
	}
}

class MyFilterForTxt implements IOFileFilter {
	private String end;
	
	public MyFilterForTxt(String end) {
		this.end = "."+end;
	}
	
	public boolean accept(File dir, String name) {
		return name.endsWith(end);
	}

	public boolean accept(File file) {
		return file.getName().endsWith(end);
	}
}
