package chapter14.bounce;

import java.awt.geom.*;

/**
 * 这个类构造了一个在矩形边框内来回弹跳的球
 * @version 1.8 2017/5/30
 * @author caoting
 */
public class Ball {
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	
	/**
	 * @param bounds 球弹跳的矩形边缘 移动到矩形边缘改变方向
	 */
	public void move(Rectangle2D bounds) {
		x += dx;
		y += dy;
		
		if(x < bounds.getMinX()) {
			x = bounds.getMinX();
			dx = -dx;
		}
		if(y < bounds.getMinY()) {
			y = bounds.getMinY();
			dy = -dy;
		}
		if(x+XSIZE > bounds.getMaxX()) {
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		if(y+YSIZE > bounds.getMaxY()) {
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}
	
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
}
