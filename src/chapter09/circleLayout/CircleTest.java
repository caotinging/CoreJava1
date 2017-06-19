package chapter09.circleLayout;

import java.awt.EventQueue;

import javax.swing.*;

/**
 * ����ഴ���Ŀ�ܲ����Զ����Բ�β��ֹ�����
 * @version 1.8 2017/4/30
 * @author caoting
 */
public class CircleTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new CircleLayoutFrame();
			frame.setTitle("Բ�β���");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
class CircleLayoutFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public CircleLayoutFrame() {
		setLayout(new CircleLayout());
		add(new JButton("Yellow"));
		add(new JButton("Blue"));
		add(new JButton("Red"));
		add(new JButton("Green"));
		add(new JButton("Orange"));
		add(new JButton("Fuchsia"));
		add(new JButton("Indigo"));
		pack();
	}
}
