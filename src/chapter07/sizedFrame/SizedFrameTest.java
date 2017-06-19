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
	 * 这个类通过获取屏幕分辨率然后取值二分之一构造框架
	 */
	private static final long serialVersionUID = 1L;

	public SizedFrame() {
		//获取屏幕的分辨率get screen dimension
		
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
