package chapter09.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 一个含有计算器和显示结果的面板
 * @version 1.8 2017/4/22
 * @author caoting
 */
public class CalculatorPanel  extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JButton display;
	private JPanel panel;
	private double reasult;
	private String lastCommand;//存取上一个运算符
	private boolean start;
	
	public CalculatorPanel() {
		setLayout(new BorderLayout());
		
		display = new JButton("0");
		reasult = 0;
		panel = new JPanel();
		lastCommand = "=";
		start = true;
		
		display.setEnabled(false);
		//设置是否启用此组件。已启用的组件可以响应用户输入，而未启用的组件则无法响应用户输入。
		//可以在禁用某些组件时更改其可视化表现形式，以向用户提供反馈，说明其无法接受输入。 
		add(display, BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		
		panel.setLayout(new GridLayout(4, 4));
		
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);
		
		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);
		
		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);
		
		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);
		
		add(panel, BorderLayout.CENTER);
	}
	public void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	//私有内部类 负责响应数字按钮 并且显示出来
	private class InsertAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input = event.getActionCommand();
			System.out.println(input);
			if(start) {
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
		}
	}
	
	//私有内部类 负责响应运算符按钮 
	private class CommandAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();
			System.out.println(command);
			if(start) {
				if(command.equals("-")) {
					display.setText(command);
					start = false;
				}
				else
					lastCommand = command;
			}
			else {
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start = true;
			}
		}
	}
	
	//进行加减乘除运算 并将结果显示出来
	public void calculate(double x) {
		if(lastCommand.equals("+"))
			reasult += x;
		else if(lastCommand.equals("-"))
			reasult -= x;
		else if(lastCommand.equals("*"))
			reasult *= x;
		else if(lastCommand.equals("/"))
			reasult /= x;
		else if(lastCommand.equals("="))
			reasult = x;
		System.out.println(reasult);
		display.setText("" + reasult);
	}
}
