package chapter07.sizedFrame;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.8 2017/4/12
 * @author caoting
 */
public class SizedFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new SizedFrame();
				frame.setTitle("SizedFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class SizedFrame extends JFrame {
	/**
	 * �����ͨ����ȡ��Ļ�ֱ���Ȼ��ȡֵ����֮һ������
	 */
	private static final long serialVersionUID = 1L;

	public SizedFrame() {
		//��ȡ��Ļ�ķֱ���get screen dimension
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		//set frame width,height and let platform pick screen location.
		
		this.setSize(screenWidth / 2, screenHeight / 2);
		setLocationByPlatform(true);
		
		//set frame icon
		
		Image img = new ImageIcon("icon.gif").getImage();
		setIconImage(img);
	}
}
