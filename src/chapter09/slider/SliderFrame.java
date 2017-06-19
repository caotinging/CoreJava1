package chapter09.slider;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * ������кܶ�������� �и���ʾ������ֵ���ı���
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
		
		//����һ�����л�������ͬʹ�õļ�����
		listener = event-> {
				JSlider source = (JSlider) event.getSource();
				textField.setText("" + source.getValue());
		};
		
		//����һ��ɶ��û�еĿջ�����
		JSlider slider = new JSlider();
		addSlider(slider, "Plain");
		
		//����һ���п̶ȵĻ�����
		slider = new JSlider();
		slider.setPaintTicks(true);//�̶ȿɼ�
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Ticks");
		
		//����һ��ǿ�ƶ����ߵĻ�����
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Snap To Ticks");
		
		//����һ��û�й켣�Ļ�����
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider, "No Track");
		
		//����һ������̶ȵĻ�����
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider, "Inverted");
		
		//����һ���б�ǩ�Ļ�����
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Labels");
		
		//����һ�����Զ����ǩ�Ļ�����
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
		
		//����һ����ͼ���Զ����ǩ�Ļ�����
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
		
		//����һ���ı�����ʾ��������ֵ
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
		//���ô�ֱ���뷽ʽ(��������)
		
		GridBagConstraints gbc = new GridBagConstraints();
		//GridBagConstraints ��ָ��ʹ�� GridBagLayout �಼�õ������Լ��
		gbc.gridy = sliderPanel.getComponentCount();
		//gridyָ��λ�������ʾ����Ķ����ĵ�Ԫ���������ϱߵĵ�Ԫ��Ϊ gridy=0
		gbc.anchor = GridBagConstraints.WEST;
		//�����С������ʾ����ʱʹ�ô��ֶΡ�������ȷ������ʾ�����з��������λ�á�(.anchor)
		
		sliderPanel.add(panel, gbc);
		//add(Component comp, Object constraints) 
		//comp - Ҫ��ӵ����   constraints - ��ʾ������Ĳ���Լ���Ķ��� (gbc)
	}
}
