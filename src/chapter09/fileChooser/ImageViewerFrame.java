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
			 * 该文件选择器被弹下时的返回状态： 
			 * JFileChooser.CANCEL_OPTION 
			 * JFileChooser.APPROVE_OPTION 
			 * JFileChooser.ERROR_OPTION 如果发生错误或者该对话框已被解除 
			 */
			int result = chooser.showOpenDialog(ImageViewerFrame.this);
//			弹出一个 "Open File" 文件选择器对话框
			if(result == JFileChooser.APPROVE_OPTION) {
//				APPROVE_OPTION选择确认（yes、ok）后返回该值
				String name = chooser.getSelectedFile().getPath();
//				String getPath()将此抽象路径名转换为一个路径名字符串
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
//		使用指定的描述和文件扩展名创建一个 FileNameExtensionFilter
		chooser.setFileFilter(filter);
		chooser.setAccessory(new ImagePreviewer(chooser));
		chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
	}
}
