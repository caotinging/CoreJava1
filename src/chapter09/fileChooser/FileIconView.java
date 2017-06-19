package chapter09.fileChooser;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * ����ļ���ͼΪ�ض����ļ�������ƥ����Ӧ���ļ���ʾͼƬ
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
//			isDirectory() ���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼��
//			accept(File f)�˹������Ƿ���ܸ������ļ���
			return icon;
		
		else return null;
	}
}
