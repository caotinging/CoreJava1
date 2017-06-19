package chapter10.properties;

import java.awt.EventQueue;
import java.io.*;
import java.util.prefs.*;
import javax.swing.*;

/**
 * 保存程序首选项属性的类。。
 * @version 1.8 2017/5/11
 * @author caoting
 */
public class PreferencesTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new PreferencesFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class PreferencesFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public PreferencesFrame() {
		Preferences root = Preferences.userRoot();
//		返回调用用户的根首选项节点
		final Preferences node = root.node("/com/horstmann/corejava");
		int left = node.getInt("left", 0);
		int top = node.getInt("top", 0);
		int width = node.getInt("width", DEFAULT_WIDTH);
		int height = node.getInt("height", DEFAULT_HEIGHT);
		setBounds(left, top, width, height);
//		getInt(String key, int def)返回与此首选项节点中与指定键相关联的、由字符串表示的 int 值
		
		String title = node.get("title", "");
		if(title.equals(""))
			title = JOptionPane.showInputDialog("请输入标题 :");
		if(title == null)
			title = "";
		setTitle(title);
		
		final JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
//		设置当前目录
		
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
//      这里因为IO包中也有一个FileFilter类 因此用这种方法得以区分
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getName().toLowerCase().endsWith(".xml") || f.isDirectory();
//				getName()返回由此抽象路径名表示的文件或目录的名称。该名称是路径名名称序列中的最后一个名称
//				toLowerCase()使用默认语言环境的规则将此 String 中的所有字符都转换为小写
//				endsWith() 测试此字符串是否以指定的后缀结束
//				isDirectory() 测试此抽象路径名表示的文件是否是一个目录
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "XML files";
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem exportItem = new JMenuItem("Export preferences");
		menu.add(exportItem);
		exportItem.addActionListener(event -> {
			if(chooser.showSaveDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
//				如果弹出的save对话框用户选择的是approve按钮 则执行if里面的内容
				try {
					OutputStream out = new FileOutputStream(chooser.getSelectedFile());
//					创建一个向指定 File 对象表示的文件中写入数据的文件输出流
					node.exportSubtree(out);
//					将这个节点及其子节点的首选项写到指定流中
					out.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JMenuItem importItem = new JMenuItem("Import preferences");
		menu.add(importItem);
		importItem.addActionListener(event -> {
			if(chooser.showOpenDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
				try {
					InputStream in = new FileInputStream(chooser.getSelectedFile());
					Preferences.importPreferences(in);
//					导入指定输入流中由 XML 文档表示的所有首选项
					in.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(event -> {
			node.putInt("left", getX());
			node.putInt("top", getY());
			node.putInt("width", getWidth());
			node.putInt("height", getHeight());
			node.put("title", getTitle());
			System.exit(0);
		});
	}
}
