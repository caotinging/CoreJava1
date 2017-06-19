package chapter08.mouse;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;

public class MouseComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private static final int SIDELENGTH = 10;
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	
	public MouseComponent() {
		squares = new ArrayList<>();
		current = null;
		
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}
	
	//组件有任何变化都会被调用
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		//绘制所有方块
		for(Rectangle2D r : squares) 
			g2.draw(r);
	}
	
	/**
	 * 判断点击的区域是否有方块
	 * @return 返回区域内包含p点的第一个矩形
	 */
	public Rectangle2D find(Point2D p) {
		for(Rectangle2D r : squares) {
			if(r.contains(p)) return r;
		}
		return null;
	}
	
	/**
	 * 新绘制一个方块并加入squares数组中
	 */
	public void add(Point2D p) {
		double x = p.getX();
		double y = p.getY();
		
		current = new Rectangle2D.Double(x-SIDELENGTH/2, y-SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
		squares.add(current);
		repaint();//刷新面板重新绘制
	}
	
	//删除一个方块
	public void remove(Rectangle2D s) {
		if(s == null)
			return;
		if(s == current) {
			current = null;
			squares.remove(s);
			repaint();
		}
	}
	
	//控制鼠标点击动作的私有内部类
	private class MouseHandler extends MouseAdapter {
		//mousePressed方法按下鼠标添加方块
		public void mousePressed(MouseEvent event) {
			current = find(event.getPoint());
			if(current == null)
				add(event.getPoint());
		}
		//mouseClicked方法 双击移除方块
		public void mouseClicked(MouseEvent event) {
			current = find(event.getPoint());
			if(current != null && event.getClickCount() >= 2)
				remove(current);
		}
	}
	
	//控制鼠标移动的私有内部类
	/**
	 * void mouseDragged(MouseEvent e)  鼠标按键在组件上按下并拖动时调用。 
	 * void mouseMoved(MouseEvent e) 鼠标光标移动到组件上但无按键按下时调用。 
	 */
	private class MouseMotionHandler implements MouseMotionListener {
		public void mouseMoved(MouseEvent event) {
			//Toolkit tk = Toolkit.getDefaultToolkit();
			//Image img = tk.getImage("bule-ball.gif");
			//Cursor dynamiteCursor = tk.createCustomCursor(img, new Point(1, 1), "dynamite stick");
			
			if(find(event.getPoint()) == null)
				setCursor(Cursor.getDefaultCursor());
			else
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}
		public void mouseDragged(MouseEvent event) {
			if(current != null) {
				double x = event.getX();
				double y = event.getY();
				
				current.setFrame(x-SIDELENGTH/2, y-SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
				repaint();
			}
		}
	}
}
