package chapter07.draw;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * @version 1.8 2017/4/13
 * @author caoting
 */
public class DrawTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new DrawFrame();
				frame.setTitle("Draw");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * JFrame继承类
 */
class DrawFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}
}

/**
 * 图形组件 
 */
class DrawComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT = 400;
	private static final int DEFAULT_WIDTH = 400;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		double x = 100;
		double y = 100;
		double radius = 100;
		
		//draw a circle
		Ellipse2D ell = new Ellipse2D.Double(x, y, x + radius, y + radius);
		g2.setPaint(Color.RED);
		g2.draw(ell);
		//draw a rectangle
		double width = radius;
		double height = radius - 20;
		double centerX = ell.getCenterX();
		double centerY = ell.getCenterY();
		Rectangle2D rect = new Rectangle2D.Double(centerX-width/2, centerY-height/2, width, height);
		//g2.setPaint(Color.BLACK);
		g2.fill(rect);
		//draw a ellipse
		Ellipse2D ell2 = new Ellipse2D.Double(centerX-width/2, centerY-height/2, width, height);
		g2.setPaint(Color.ORANGE);
		g2.fill(ell2);
		//draw a line
		Point2D began = new Point2D.Double(centerX-width/2, centerY-height/2);
		Point2D end = new Point2D.Double(centerX+width/2, centerY+height/2);
		Line2D line = new Line2D.Double(began, end);
		g2.setPaint(Color.red);
		g2.draw(line);
	}
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}