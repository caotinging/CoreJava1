package chapter10.webstart;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new CalculatorFrame();
			frame.setTitle("Calculator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
class CalculatorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	public CalculatorFrame() {
		panel = new CalculatorPanel();
		
		add(panel);
		pack();
	}
}
