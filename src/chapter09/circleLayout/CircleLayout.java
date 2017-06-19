package chapter09.circleLayout;

import java.awt.*;

/**
 * һ�����ƵĲ��ֹ�����
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
//		��ȡ������е�������� 
		
		preferredWidth = 0;
		preferredHeight = 0;
		minWidth = 0;
		minHeight= 0;
		maxComponentWidth = 0;
		maxComponentHeight = 0;
		
		for(int i = 0; i < n; i++) {
			Component c = parent.getComponent(i);
//			��ȡ�������еĵ� i ������� 
			if(c.isVisible()) {
//			ȷ����������丸�����ɼ�ʱ�Ƿ�Ӧ�ÿɼ��������ʼ�ǿɼ��ģ����� Frame ����ȶ���������⡣ 
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
		
//		����Բ��Բ�� center
		Insets insets = parent.getInsets();
		//�ȼ�������ʵ�ʴ�С ��Ҫ����Ϊ�����������Ŀհ״�С���ܲ�һ��
		int containerWidth = parent.getSize().width - insets.left - insets.right;
		int containerHeight = parent.getSize().height - insets.top - insets.bottom;
		int xcenter = insets.left + containerWidth / 2;
		int ycenter = insets.top + containerHeight / 2;
		
//		����Բ�İ뾶 radius
		int xradius = (containerWidth - maxComponentWidth) / 2;
		int yradius = (containerHeight - maxComponentHeight) / 2;
		
		int radius = Math.min(xradius, yradius);
		
		int n = parent.getComponentCount();
		for(int i = 0; i < n; i++) {
			Component c = parent.getComponent(i);
			if(c.isVisible()) {
				double angle = 2 * Math.PI * i / n;
				//ƽ��ÿ�������ռ�Ƕ����
				
				int x = xcenter + (int) (Math.cos(angle) * radius);
				int y = ycenter + (int) (Math.sin(angle) * radius);
				//��������ѧ���� �뿴�鱾391
				
				Dimension d = c.getPreferredSize();
				c.setBounds(x - d.width / 2, y - d.height / 2, d.width, d.height);
//				�ƶ�������������С���� x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С�� 
			}
		}
	}
}
