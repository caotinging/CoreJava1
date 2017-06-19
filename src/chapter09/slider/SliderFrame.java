package chapter09.slider;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 这个类有很多个滑动器 有个显示滑动器值的文本域
 * @version 1.8 2017/4/25
 * @author caoting
 */
public class SliderFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;
	
	public SliderFrame() {
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		
		//设置一个所有滑动器共同使用的监听器
		listener = event-> {
				JSlider source = (JSlider) event.getSource();
				textField.setText("" + source.getValue());
		};
		
		//设置一个啥都没有的空滑动器
		JSlider slider = new JSlider();
		addSlider(slider, "Plain");
		
		//设置一个有刻度的滑动器
		slider = new JSlider();
		slider.setPaintTicks(true);//刻度可见
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Ticks");
		
		//设置一个强制对齐标尺的滑动器
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Snap To Ticks");
		
		//设置一个没有轨迹的滑动器
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider, "No Track");
		
		//设置一个反向刻度的滑动器
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider, "Inverted");
		
		//设置一个有标签的滑动器
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Labels");
		
		//设置一个有自定义标签的滑动器
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		Dictionary<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		
		slider.setLabelTable(labelTable);
		addSlider(slider, "Custom Labels");
		
		//设置一个用图案自定义标签的滑动器
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(20);
		
		labelTable = new Hashtable<Integer, Component>();
		labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
		labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
		labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
		labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
		labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
		labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));
		
		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon Labels");
		
		//设置一个文本域显示滑动器的值
		textField= new JTextField();
		add(sliderPanel, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		pack();
	}
	
	public void addSlider(JSlider s, String description) {
		s.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		//设置垂直对齐方式(组件左对齐)
		
		GridBagConstraints gbc = new GridBagConstraints();
		//GridBagConstraints 类指定使用 GridBagLayout 类布置的组件的约束
		gbc.gridy = sliderPanel.getComponentCount();
		//gridy指定位于组件显示区域的顶部的单元格，其中最上边的单元格为 gridy=0
		gbc.anchor = GridBagConstraints.WEST;
		//当组件小于其显示区域时使用此字段。它可以确定在显示区域中放置组件的位置。(.anchor)
		
		sliderPanel.add(panel, gbc);
		//add(Component comp, Object constraints) 
		//comp - 要添加的组件   constraints - 表示此组件的布局约束的对象 (gbc)
	}
}
