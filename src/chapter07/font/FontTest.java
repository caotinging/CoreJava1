package chapter07.font;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * 设置字体打印在框架中
 * @version 1.8 2017/4/14
 * @author caoting
 */
public class FontTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame = new FontFrame();
				frame.setTitle("Font Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class FontFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public FontFrame() {
		add(new FoneComponent());
		pack();
	}
}

class FoneComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		//设置字体
		String Message = "Hello World!";
		Font f = new Font("serif", Font.BOLD, 36);
		g2.setFont(f);
		
		//获取包围字体大小的矩形
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D rect = f.getStringBounds(Message, context);
		
		//获取组件大小和矩形大小计算得出字体打印的中间位置
		double x = (getWidth()-rect.getWidth()) / 2;
		double y = (getHeight()-rect.getHeight())/ 2;
		double ascent = -rect.getY();
		double baseY = ascent + y;
		
		g2.drawString(Message, (int) x, (int) baseY);//参数只能int 类型
		g2.setColor(Color.LIGHT_GRAY);
		
		//画基线
		Line2D baseLine = new Line2D.Double(x, baseY, x+rect.getWidth(), baseY);
		g2.draw(baseLine);
		
		//❀画包围的矩形
		Rectangle2D bounds = new Rectangle2D.Double(x, y, rect.getWidth(), rect.getHeight());
		g2.draw(bounds);
	}
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}