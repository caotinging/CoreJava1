package chapter09.toolBar;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ToolBarTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new ToolBarFrame();
			frame.setTitle("¹¤¾ßÀ¸");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
