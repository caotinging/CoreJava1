package chapter14.bounce;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @version 1.8 2017/5/30
 * @author caoting
 */
public class Bounce {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new BounceFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class BounceFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private BallComponent comp;
	private static String fButton = "Start";
	private static String sButton = "Close";
	private static final int STEPS = 1000;
	private static final int DELAY = 3;
	
	public BounceFrame () {
		comp = new BallComponent();
		
		setTitle("蹦蹦球");
		add(comp, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, fButton, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addBall();
			}
		});
		addButton(buttonPanel, sButton, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	
	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	public void addBall() {
		try {
			Ball ball = new Ball();
			comp.add(ball);
			
			for(int i = 1; i <= STEPS; i++) {
				ball.move(comp.getBounds());
				comp.paint(comp.getGraphics());
//				getGraphics() 返回此组件的图形上下文，该上下文允许您绘制组件
				Thread.sleep(DELAY);
//				休眠给定毫秒数
			}
		}
		catch(InterruptedException e) {
		}
	}
}
