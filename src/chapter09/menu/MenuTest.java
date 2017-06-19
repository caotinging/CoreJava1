package chapter09.menu;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MenuTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new MenuFrame();
			frame.setTitle("²Ëµ¥À¸");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
