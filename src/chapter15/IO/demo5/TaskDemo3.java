package chapter15.IO.demo5;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/**
 * 获取指定目录及子目录下所有txt文件的个数，并将这些txt文件复制到D盘下任意目录
 * 利用工具类完成
 * @author caoting
 *
 */

public class TaskDemo3 {
	public static void main(String[] args) {
		Collection<File> list = getTxt();
		System.out.println(list);
	}
	
	public static  Collection<File> getTxt() {
		//获取指定目录及子目录下的所有txt文件
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
