package chapter07.notHelloWorld;

import java.awt.*;
import javax.swing.*;

/**
 * This program adds the component to the framework
 * @version 1.8 2017/4/13
 * @author caoting
 */
public class NotHelloWorld {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new NotHelloWorldFrame();
				JFrame frameCopy = new NotHelloWorldFrame(true);
				
				frameCopy.setTitle("�Ұ���");
				frameCopy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameCopy.setVisible(true);
				
				frame.setTitle("Not Hello World");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * ����������������� һ�������������������ѡ�ߴ繹��
 * һ�����Ȼ�ȡ��Ļ�ߴ�Ȼ��ȡֵ��һ����Ϊ�ߴ�
 */
class NotHelloWorldFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NotHelloWorldFrame() {
		add(new NotHelloWorldComponent());
		pack();
	}
	public NotHelloWorldFrame(boolean b) {
		if(b){
			add(new NotHelloWorldComponent());
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int height = screenSize.height / 2;
			int width = screenSize.width / 2;
			
			setSize(width, height);
			setLocationByPlatform(true);
			
			Image img = new ImageIcon("icon.jif").getImage();
			setIconImage(img);
		}
		else {
			add(new NotHelloWorldComponent());
			pack();
		}
	}
}

/**
 * һ���ڿ�����ӡ hello world �����
 */
class NotHelloWorldComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MESSAGE_X = 75;
	private static final int MESSAGE_Y = 100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g) {
		g.drawString("I love you YH", MESSAGE_X, MESSAGE_Y);
	}
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}

