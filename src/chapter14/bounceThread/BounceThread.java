package chapter14.bounceThread;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import chapter14.bounce.*;

/**
 * 这个类使用独立的线程移动球 可以同时移动多个球并且球移动过程能响应close按钮
 * @version 1.8 2017/5/31
 * @author caoting
 */
public class BounceThread {
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
	
	private static final int DEFAULTWIDTH = 450;
	private static final int DEFAULTHEIGHT = 350;
	private BallComponent comp;
	
	public BounceFrame() {
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BallRunnable b = new BallRunnable(comp);
				Thread t = new Thread(b);
				t.start();
			}
		});
		addButton(buttonPanel, "Close", new ActionListener() {
			public void actionPerformed(ActionEvent event){
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
	
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULTWIDTH, DEFAULTHEIGHT);
	}
}

class BallRunnable implements Runnable {
	private static final int STEPS = 1000;
	private static final int DELAY = 3;
	private BallComponent comp;
	
	//public BallRunnable() {}
	
	/**
	 * @param c only BallComponent.class
	 */
	public BallRunnable(BallComponent c) {
		comp = c;
	}
	public void run() {
		Ball ball = new Ball();
		try {
			comp.add(ball);
			for(int i = 1; i <= STEPS; i++) {
				ball.move(comp.getBounds());
				comp.paint(comp.getGraphics());
				Thread.sleep(DELAY);
			}
		} 
		catch(InterruptedException e) {
		}
	}
}
