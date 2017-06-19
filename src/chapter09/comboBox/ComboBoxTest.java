package chapter09.comboBox;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ComboBoxTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ComboBoxFrame();
				frame.setTitle("×éºÏ¿ò");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
