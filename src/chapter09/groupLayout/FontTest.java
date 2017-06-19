package chapter09.groupLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;

import chapter09.gridbag.FontFrame;

public class FontTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new FontFrame();
				frame.setTitle("×ÖÌå");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
