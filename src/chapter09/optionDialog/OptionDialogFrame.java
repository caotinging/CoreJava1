package chapter09.optionDialog;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;

/**
 * 这个类可以通过面板控制对话框类型
 * @version 1.8 2017/5/1
 * @author caoting
 */
public class OptionDialogFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ButtonPanel typePanel;
	private ButtonPanel messagePanel;
	private ButtonPanel messageTypePanel;
	private ButtonPanel optionTypePanel;
	private ButtonPanel optionsPanel;
	private ButtonPanel inputPanel;
	
	private String messageString = "Message";
	private Icon messageIcon = new ImageIcon("blue-ball.gif");
	private Object messageObject = new Date();
	private Component messageComponent = new SampleComponent();
	
	public OptionDialogFrame() {
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2, 3));
		
		typePanel = new ButtonPanel("Type", "Message", "Confirm", "Option", "Input");
//		对话框的类型 （消息对话框，确认对话框，选项对话框或者输入对话框）
		messageTypePanel = new ButtonPanel("Message Type", "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE",
				"QUESTION_MESSAGE", "PLAIN_MESSAGE");
//		对话框信息的默认图标类型 （错误，信息，警告，问题，无或者自定义）
		messagePanel = new ButtonPanel("Message", "String", "Icon", "Component", "Other", "Object[]");
//		对话框显示的消息类型 （字符串，图像，组件或者集合）
		
		/**
		 * 定义在对话框的底部显示的选项按钮的集合
		 */
		optionTypePanel = new ButtonPanel("Confirm", "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION");
//		对于确认对话框，选择选项类型 （默认，yes/no, yes/no/cancel, ok/cancel）
		optionsPanel = new ButtonPanel("Option", "String[]", "Icon[]", "Object[]");
//		对于选项对话框，选择选项类型（字符串，图表，或者自定义组件）
		inputPanel = new ButtonPanel("Input", "Text field", "Combo box");
//		对于输入对话框，选择输入类型（文本框输入或者组合框选择选项输入）
		
		gridPanel.add(typePanel);
		gridPanel.add(messagePanel);
		gridPanel.add(messageTypePanel);
		gridPanel.add(optionsPanel);
		gridPanel.add(optionTypePanel);
		gridPanel.add(inputPanel);
		
		JPanel showPanel = new JPanel();
		JButton showButton = new JButton("SHOW");
		showButton.addActionListener(new ShowAction());
		showPanel.add(showButton);
		
		add(gridPanel, BorderLayout.CENTER);
		add(showPanel, BorderLayout.SOUTH);
		pack();
	}
	
	/**
	 * 这个类获取当前选择的信息并返回
	 * @return Object 具体类型依赖Message面板的选择
	 */
	public Object getMessage() {
		String s = messagePanel.getSelection();
//		getSelection 是Buttonpanel内定义的方法 返回面板中选择的动作命令ActionCommand
		if(s.equals("String")) return messageString;
		else if(s.equals("Icon")) return messageIcon;
		else if(s.equals("Component")) return messageComponent;
		else if(s.equals("Option[]")) return new Object[]{ messageString,
				messageIcon, messageComponent, messageObject};
		else return null;
	}
	
	/**
	 * 这个类获取当前选择的选项类型
	 * @return Object[] 具体数组类型依赖options面板的选择
	 */
	public Object[] getOptions() {
		String s = optionsPanel.getSelection();
		if(s.equals("String[]")) return new String[] { "Yellow", "Blue", "Red" };
		else if(s.equals("Icon[]")) return new Icon[] { new ImageIcon("yellow-ball.gif"), 
				new ImageIcon("blue-ball.gif"), new ImageIcon("red-ball.gif") };
		else if(s.equals("Object[]")) return new Object[] { messageString, messageIcon,
				messageComponent, messageObject };
		else return null;
		}
	
	public int getType(ButtonPanel panel) {
		String s = panel.getSelection();
		try {
			return JOptionPane.class.getField(s).getInt(null);
		}
		catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * 私有内部类 实现ActionListener接口 与show按钮关联
	 */
	private class ShowAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
//			如果选择的是确认对话框
			if(typePanel.getSelection().equals("Confirm"))
				JOptionPane.showConfirmDialog(OptionDialogFrame.this, getMessage(), "确认对话框", 
						getType(optionTypePanel), getType(messageTypePanel));
			
//			如果选择的是输入对话框
			else if(typePanel.getSelection().equals("Input")) {
				//文本框输入
				if(inputPanel.getSelection().equals("Text field"))
					JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), 
							"文本框输入", getType(messageTypePanel));
				else JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(),
						"组合框输入", getType(messageTypePanel), null, 
						new String[] { "Yellow", "Blue", "Red" }, "Blue");
			}
			else if (typePanel.getSelection().equals("Message")) 
				JOptionPane.showMessageDialog(OptionDialogFrame.this, getMessage(), "消息对话框", 
						getType(messageTypePanel));
			else if (typePanel.getSelection().equals("Option"))
				JOptionPane.showOptionDialog(OptionDialogFrame.this, getMessage(), "选项对话框",
						getType(optionTypePanel), getType(messageTypePanel), null, getOptions(), getOptions()[0]);
		}
	}
}
class SampleComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
		g2.setPaint(Color.yellow);
//		为 Graphics2D 上下文设置 Paint 属性
		g2.fill(rect);
		g2.setPaint(Color.BLUE);
//		矩形的框框是蓝色 内部是黄色
		g2.draw(rect);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(10, 10);
	}
}
