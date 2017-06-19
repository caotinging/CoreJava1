package chapter10.resource;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

/**
 * @version 1.8 2017/5/6
 * @author caoting
 */
public class ResourceTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new ResourceFrame();
			frame.setTitle("Resource Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

/**
 * һ����λͼƬ���ı���Դ�Ŀ����
 */
class ResourceFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ResourceFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		URL aboutURL = getClass().getResource("about.gif");
		Image img = new ImageIcon(aboutURL).getImage();
		setIconImage(img);
//		����Ҫ��Ϊ�˴���ͼ����ʾ��ͼ��
		
		JTextArea textArea = new JTextArea();
		InputStream stream = getClass().getResourceAsStream("about.txt");
		try(Scanner in = new Scanner(stream, "UTF-8")) {
			while(in.hasNext()) 
//				 hasNextXxx()���Ƿ�����һ�������
//				����Xxx������Int��Long�ȴ�������������͵��ַ�����
//				�����Ҫ�ж��Ƿ������һ���ַ���������ʡ��Xxx.
				textArea.append(in.nextLine() + "\n");
//			�������ı�׷�ӵ��ı����ĵ�ǰ�ı��� 
		}
		add(textArea);
	}
}
