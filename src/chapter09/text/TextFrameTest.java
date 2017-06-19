package chapter09.text;

import java.awt.*;

import javax.swing.*;

import chapter09.slider.SliderFrame;

public class TextFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new SliderFrame();
				frame.setTitle("√‹¬Î");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
