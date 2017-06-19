package chapter09.fileChooser;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * 这个文件视图为特定的文件过滤器匹配相应的文件显示图片
 * @version 1.8 2017/5/3
 * @author caoting
 */
public class FileIconView extends FileView {
	private FileFilter filter;
	private Icon icon;
	
	public FileIconView(FileFilter fliter, Icon icon) {
		this.filter = fliter;
		this.icon = icon;
	}
	
	public Icon getIcon(File f) {
		if(!f.isDirectory() && filter.accept(f)) 
//			isDirectory() 测试此抽象路径名表示的文件是否是一个目录。
//			accept(File f)此过滤器是否接受给定的文件。
			return icon;
		
		else return null;
	}
}
