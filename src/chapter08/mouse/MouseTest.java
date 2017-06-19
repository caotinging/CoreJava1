package chapter08.mouse;

import java.awt.EventQueue;

import javax.swing.*;

/**
 * this program is for testing
 * @version 1.82017/4/18
 * @author caoting
 */
public class MouseTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MouseFrame();
				frame.setTitle("Mouse Squares");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
