package chapter09.calculator;

import java.awt.*;

import javax.swing.*;

public class CalculateTest {
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new CalFrame();
				frame.setTitle("¼ÆËãÆ÷");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class CalFrame extends JFrame {
	private static final long  serialVersionUID = 1L;
	public CalFrame() {
		add(new CalculatorPanel());
		pack();
	}
}