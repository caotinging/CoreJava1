package chapter08.mouse;

import javax.swing.*;
/**
 * a frame containing a panel for testing mouse operations
 * @version 1.8 2017/4/18
 * @author caoting
 */
public class MouseFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;

	public MouseFrame() {
		setSize(WIDTH, HEIGHT);
		add(new MouseComponent());
	}
}
