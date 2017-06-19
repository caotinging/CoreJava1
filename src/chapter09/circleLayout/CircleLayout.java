package chapter09.circleLayout;

import java.awt.*;

/**
 * 一个定制的布局管理器
 * @version 1.8 2017/4/30
 * @author caoting
 */
public class CircleLayout implements LayoutManager{
	private int minWidth = 0;
	private int minHeight = 0;
	private int preferredWidth = 0;
	private int preferredHeight = 0;
	private boolean sizesSet = false;
	private int maxComponentWidth = 0;
	private int maxComponentHeight = 0;

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
	}
	
	public void setSizes(Container parent) {
		if(sizesSet) return;
		int n = parent.getComponentCount();
//		获取此面板中的组件数。 
		
		preferredWidth = 0;
		preferredHeight = 0;
		minWidth = 0;
		minHeight= 0;
		maxComponentWidth = 0;
		maxComponentHeight = 0;
		
		for(int i = 0; i < n; i++) {
			Component c = parent.getComponent(i);
//			获取此容器中的第 i 个组件。 
			if(c.isVisible()) {
//			确定此组件在其父容器可见时是否应该可见。组件初始是可见的，诸如 Frame 对象等顶层组件除外。 
				Dimension d = c.getPreferredSize();
				maxComponentWidth = Math.max(maxComponentWidth, d.width);
				maxComponentHeight = Math.min(maxComponentHeight, d.height);
				preferredWidth += d.width;
				preferredHeight += d.height;
			}
		}
		minWidth = preferredWidth / 2;
		minHeight = preferredHeight / 2;
		sizesSet = true;
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = preferredWidth + insets.left + insets.right;
		int height = preferredHeight + insets.top + insets.bottom;
		return new Dimension(width, height);
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = minWidth + insets.left + insets.right;
		int height = minHeight + insets.top + insets.bottom;
		return new Dimension(width, height);
	}

	@Override
	public void layoutContainer(Container parent) {
		// TODO Auto-generated method stub
		setSizes(parent);
		
//		计算圆的圆心 center
		Insets insets = parent.getInsets();
		//先计算容器实际大小 主要是因为左右上下填充的空白大小可能不一样
		int containerWidth = parent.getSize().width - insets.left - insets.right;
		int containerHeight = parent.getSize().height - insets.top - insets.bottom;
		int xcenter = insets.left + containerWidth / 2;
		int ycenter = insets.top + containerHeight / 2;
		
//		计算圆的半径 radius
		int xradius = (containerWidth - maxComponentWidth) / 2;
		int yradius = (containerHeight - maxComponentHeight) / 2;
		
		int radius = Math.min(xradius, yradius);
		
		int n = parent.getComponentCount();
		for(int i = 0; i < n; i++) {
			Component c = parent.getComponent(i);
			if(c.isVisible()) {
				double angle = 2 * Math.PI * i / n;
				//平均每个组件所占角度相等
				
				int x = xcenter + (int) (Math.cos(angle) * radius);
				int y = ycenter + (int) (Math.sin(angle) * radius);
				//这里是数学问题 请看书本391
				
				Dimension d = c.getPreferredSize();
				c.setBounds(x - d.width / 2, y - d.height / 2, d.width, d.height);
//				移动组件并调整其大小。由 x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。 
			}
		}
	}
}
