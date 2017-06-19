package chapter09.gridbag;

import java.awt.*;

/**
 * 这个类简化了网格组布局的使用
 * @version 1.8 2017/4/29
 * @author caoting
 */
public class GBC extends GridBagConstraints {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用给定的值初始化gridx和gridy的值 其余参数使用默认值
	 * @param gridx the gridx position
	 * @param gridy the gridy position
	 */
	public GBC(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
	}
	
	/**
	 * 用给定的值初始化所有参数
	 * @param gridx the gridx position
	 * @param gridy the gridy position
	 * @param gridwidth the cell span in x-direction
	 * @param gridheight the cell span in y-direction
	 */
	public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}
	
	/**
	 * set the anchor
	 * @param anchor the anchor value
	 * @return this object for further modification
	 */
	public GBC setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}
	
	/**
	 * set the fill direction
	 * @param fill the fill value
	 * @return this object for futher modificaion
	 */
	public GBC setFill(int fill) {
		this.fill = fill;
		return this;
	}
	
	/**
	 * set the cell weights 设置单元增重
	 * @param weightx the cell weight in x-direction
	 * @param weighty the cell weight in y-direction
	 * @return this object for futher modification
	 */
	public GBC setWeight(double weightx, double weighty) {
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	
	/**
	 * set the insets of this cell
	 * @param instance the spacing to use in all direction
	 * @return the object for futher modification
	 */
	public GBC setInsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}
	
	/**
	 * set the insets of this cell
	 * @param top the spacing to use on top
	 * @param left the spacing to use to the left
	 * @param buttom the spacing to use on buttom
	 * @param right the spacing to use to the right
	 * @return the object for futher modification
	 */
	public GBC setInsets(int top, int left, int buttom, int right) {
		this.insets = new Insets(top, left, buttom, right);
		return this;
	}
	
	/**
	 * set the internal padding
	 * @param ipadx the internal padding in x-direction
	 * @param ipady the internal padding in y-direction
	 * @return the object for futher modification
	 */
	public GBC setIpad(int ipadx, int ipady) {
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
}
