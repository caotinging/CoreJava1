package chapter14.bounce;

import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;

/**
 * 用于Ball对象弹跳的组件
 * @version 1.8 2017/5/30
 * @author caoting
 */
public class BallComponent extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULTWIDTH = 450;
	private static final int DEFAULTHEIGHT = 350;
	private List<Ball> balls = new ArrayList<>();
	
	public void add(Ball ball) {
		balls.add(ball);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Ball ball : balls) {
			g2.fill(ball.getShape());
		}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULTWIDTH, DEFAULTHEIGHT);
	}
}
