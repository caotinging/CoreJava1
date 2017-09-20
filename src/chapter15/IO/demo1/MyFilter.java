package chapter15.IO.demo1;

/**
 * 自定义一个FileFilter类
 * 用于获取后缀名是.java的文件（不区分大小写）
 */
import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		//如果是目录直接放行
		return pathname.getName().toLowerCase().endsWith(".java");
	}
}
