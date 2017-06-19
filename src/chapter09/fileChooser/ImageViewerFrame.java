package chapter09.fileChooser;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImageViewerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	private JLabel label;
	private JFileChooser chooser;
	
	public ImageViewerFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		JMenu file = new JMenu("File");
		menu.add(file);
		
		JMenuItem openItem = new JMenuItem("Open");
		file.add(openItem);
		
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		openItem.addActionListener(event -> {
			chooser.setCurrentDirectory(new File("."));
			
			/**
			 * ���ļ�ѡ����������ʱ�ķ���״̬�� 
			 * JFileChooser.CANCEL_OPTION 
			 * JFileChooser.APPROVE_OPTION 
			 * JFileChooser.ERROR_OPTION �������������߸öԻ����ѱ���� 
			 */
			int result = chooser.showOpenDialog(ImageViewerFrame.this);
//			����һ�� "Open File" �ļ�ѡ�����Ի���
			if(result == JFileChooser.APPROVE_OPTION) {
//				APPROVE_OPTIONѡ��ȷ�ϣ�yes��ok���󷵻ظ�ֵ
				String name = chooser.getSelectedFile().getPath();
//				String getPath()���˳���·����ת��Ϊһ��·�����ַ���
				label.setIcon(new ImageIcon(name));
				pack();
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		file.add(exitItem);
		
		exitItem.addActionListener(event -> {
			System.exit(0);
		});
		
		label = new JLabel();
		add(label);
		
		chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "gif");
//		ʹ��ָ�����������ļ���չ������һ�� FileNameExtensionFilter
		chooser.setFileFilter(filter);
		chooser.setAccessory(new ImagePreviewer(chooser));
		chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
	}
}
