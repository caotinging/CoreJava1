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
	
	//������κα仯���ᱻ����
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		//�������з���
		for(Rectangle2D r : squares) 
			g2.draw(r);
	}
	
	/**
	 * �жϵ���������Ƿ��з���
	 * @return ���������ڰ���p��ĵ�һ������
	 */
	public Rectangle2D find(Point2D p) {
		for(Rectangle2D r : squares) {
			if(r.contains(p)) return r;
		}
		return null;
	}
	
	/**
	 * �»���һ�����鲢����squares������
	 */
	public void add(Point2D p) {
		double x = p.getX();
		double y = p.getY();
		
		current = new Rectangle2D.Double(x-SIDELENGTH/2, y-SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
		squares.add(current);
		repaint();//ˢ��������»���
	}
	
	//ɾ��һ������
	public void remove(Rectangle2D s) {
		if(s == null)
			return;
		if(s == current) {
			current = null;
			squares.remove(s);
			repaint();
		}
	}
	
	//���������������˽���ڲ���
	private class MouseHandler extends MouseAdapter {
		//mousePressed�������������ӷ���
		public void mousePressed(MouseEvent event) {
			current = find(event.getPoint());
			if(current == null)
				add(event.getPoint());
		}
		//mouseClicked���� ˫���Ƴ�����
		public void mouseClicked(MouseEvent event) {
			current = find(event.getPoint());
			if(current != null && event.getClickCount() >= 2)
				remove(current);
		}
	}
	
	//��������ƶ���˽���ڲ���
	/**
	 * void mouseDragged(MouseEvent e)  ��갴��������ϰ��²��϶�ʱ���á� 
	 * void mouseMoved(MouseEvent e) ������ƶ�������ϵ��ް�������ʱ���á� 
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
