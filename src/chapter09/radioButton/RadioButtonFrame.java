package chapter09.radioButton;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 这个类通过单选框改变标签内字的大小
 * @version 1.8 2017/4/24
 * @author caoting
 */
public class RadioButtonFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
	private JLabel label;
	private ButtonGroup group;
	private static final int DEFAULT_SIZE = 12;
	
	public RadioButtonFrame() {
		label = new JLabel("Hello World!");
		label.setFont(new Font("serif", Font.PLAIN, DEFAULT_SIZE));
		
		add(label, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("Small", 8);
		addRadioButton("Medium", 12);
		addRadioButton("Large", 18);
		addRadioButton("Extra Largr", 36);
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	
	public void addRadioButton(String name, final int size) {
		boolean selected = (size == DEFAULT_SIZE);
		JRadioButton button = new JRadioButton(name, selected);
		group.add(button);
		buttonPanel.add(button);
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				label.setFont(new Font("serif", Font.PLAIN, size));
			}
		};
		
		button.addActionListener(listener);//为什么这个语句一定要在上面匿名内部类定义的后面
	}
}
