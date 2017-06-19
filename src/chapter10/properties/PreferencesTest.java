package chapter10.properties;

import java.awt.EventQueue;
import java.io.*;
import java.util.prefs.*;
import javax.swing.*;

/**
 * ���������ѡ�����Ե��ࡣ��
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
//		���ص����û��ĸ���ѡ��ڵ�
		final Preferences node = root.node("/com/horstmann/corejava");
		int left = node.getInt("left", 0);
		int top = node.getInt("top", 0);
		int width = node.getInt("width", DEFAULT_WIDTH);
		int height = node.getInt("height", DEFAULT_HEIGHT);
		setBounds(left, top, width, height);
//		getInt(String key, int def)���������ѡ��ڵ�����ָ����������ġ����ַ�����ʾ�� int ֵ
		
		String title = node.get("title", "");
		if(title.equals(""))
			title = JOptionPane.showInputDialog("��������� :");
		if(title == null)
			title = "";
		setTitle(title);
		
		final JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
//		���õ�ǰĿ¼
		
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
//      ������ΪIO����Ҳ��һ��FileFilter�� ��������ַ�����������
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getName().toLowerCase().endsWith(".xml") || f.isDirectory();
//				getName()�����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ���������·�������������е����һ������
//				toLowerCase()ʹ��Ĭ�����Ի����Ĺ��򽫴� String �е������ַ���ת��ΪСд
//				endsWith() ���Դ��ַ����Ƿ���ָ���ĺ�׺����
//				isDirectory() ���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼
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
//				���������save�Ի����û�ѡ�����approve��ť ��ִ��if���������
				try {
					OutputStream out = new FileOutputStream(chooser.getSelectedFile());
//					����һ����ָ�� File �����ʾ���ļ���д�����ݵ��ļ������
					node.exportSubtree(out);
//					������ڵ㼰���ӽڵ����ѡ��д��ָ������
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
//					����ָ������������ XML �ĵ���ʾ��������ѡ��
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
