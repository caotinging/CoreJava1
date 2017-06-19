package chapter07.simpleFrame;

import java.awt.*;
import javax.swing.*;

/**
 * This program shows a blank frame
 * @version 1.7.0_80 2017/4/11
 * @author caoting
 */
public class SimpleFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//frame.setUndecorated(true);
				//上面语句是关闭所有框架颜色
				frame.setVisible(true);
			}
		});
	}
}

class SimpleFrame extends JFrame {
	/*
	 * 下面这个东西我暂时也不明白为啥要用既然是编译器提示我用的就先用着吧 总之不用有警告就对了
	 */
	private static final long serialVersionUID = 3140674431190446603L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
