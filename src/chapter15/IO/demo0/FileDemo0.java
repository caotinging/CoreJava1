package chapter15.IO.demo0;

import java.io.File;

/**
 * java.io.File:������ϵͳ�е��ļ����ļ��У�·����װ��File����
 * �ṩ��������ϵͳ�е�����
 * 
 * �ļ���File Ŀ¼��Directory ·����Path
 * @author caoting
 */

public class FileDemo0 {
	public static void main(String[] args) {
//		File�ľ�̬��Ա����
//		windows����ϵͳ�µ�Ĭ�����Ʒָ���: \  LinuxΪ��/
		String separator = File.separator; 
		System.out.println(separator);
		
//		windows����ϵͳ�µ�Ĭ��·���ָ���:  ;���ֺţ�LinuxΪ�� : ��ð�ţ�
		separator = File.pathSeparator;
		System.out.println(separator);
		/**
		 * ע��File��̬��Ա�ָ��������ÿ���ʵ�ֿ�ƽ̨
		 */
	}
}
