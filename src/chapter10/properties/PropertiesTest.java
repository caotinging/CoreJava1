package chapter10.properties;

import java.awt.event.*;
import java.awt.EventQueue;
import java.io.*;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PropertiesTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new PropertiesFrame();
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class PropertiesFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	private File propertiesFile;
	private Properties settings;
	
	public PropertiesFrame() {
		String userDir = System.getProperty("user.home");
		File propertiesDir = new File(userDir, ".corejava");
		if(!propertiesDir.exists())
			propertiesDir.mkdir();
//		mkdir() 创建此抽象路径名指定的目录
		
		propertiesFile = new File(propertiesDir, "program.properties");
		
		Properties defaultSettings = new Properties();
		defaultSettings.put("left", "0");
		defaultSettings.put("top", "0");
		defaultSettings.put("width", "" + DEFAULT_WIDTH);
		defaultSettings.put("height", "" + DEFAULT_HEIGHT);
		defaultSettings.put("title", "");
		
		settings = new Properties(defaultSettings);
		
		if(propertiesFile.exists()) {
			try {
				FileInputStream in = new FileInputStream(propertiesFile);
				settings.load(in);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		int left = Integer.parseInt(settings.getProperty("left"));
		int top = Integer.parseInt(settings.getProperty("top"));
		int width = Integer.parseInt(settings.getProperty("width"));
		int height = Integer.parseInt(settings.getProperty("height"));
		setBounds(left, top, width, height);
		
		String title = settings.getProperty("title");
		if(title.equals("")) 
			title = JOptionPane.showInputDialog("请输入标题");
		if(title == null)
			title = "";
		setTitle(title);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
//				窗口关闭时触发的动作
				settings.put("left", "" + getX());
				settings.put("top", "" + getY());
				settings.put("width", "" + getWidth());
				settings.put("height", "" + getHeight());
//				传递给settings的属性必须是字符串形式的
				try {
					FileOutputStream out = new FileOutputStream(propertiesFile);
					settings.store(out, "program properties");
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
	}
}
