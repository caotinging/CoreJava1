package chapter09.optionDialog;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;

/**
 * ��������ͨ�������ƶԻ�������
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
//		�Ի�������� ����Ϣ�Ի���ȷ�϶Ի���ѡ��Ի����������Ի���
		messageTypePanel = new ButtonPanel("Message Type", "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE",
				"QUESTION_MESSAGE", "PLAIN_MESSAGE");
//		�Ի�����Ϣ��Ĭ��ͼ������ ��������Ϣ�����棬���⣬�޻����Զ��壩
		messagePanel = new ButtonPanel("Message", "String", "Icon", "Component", "Other", "Object[]");
//		�Ի�����ʾ����Ϣ���� ���ַ�����ͼ��������߼��ϣ�
		
		/**
		 * �����ڶԻ���ĵײ���ʾ��ѡ�ť�ļ���
		 */
		optionTypePanel = new ButtonPanel("Confirm", "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION");
//		����ȷ�϶Ի���ѡ��ѡ������ ��Ĭ�ϣ�yes/no, yes/no/cancel, ok/cancel��
		optionsPanel = new ButtonPanel("Option", "String[]", "Icon[]", "Object[]");
//		����ѡ��Ի���ѡ��ѡ�����ͣ��ַ�����ͼ�������Զ��������
		inputPanel = new ButtonPanel("Input", "Text field", "Combo box");
//		��������Ի���ѡ���������ͣ��ı������������Ͽ�ѡ��ѡ�����룩
		
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
	 * ������ȡ��ǰѡ�����Ϣ������
	 * @return Object ������������Message����ѡ��
	 */
	public Object getMessage() {
		String s = messagePanel.getSelection();
//		getSelection ��Buttonpanel�ڶ���ķ��� ���������ѡ��Ķ�������ActionCommand
		if(s.equals("String")) return messageString;
		else if(s.equals("Icon")) return messageIcon;
		else if(s.equals("Component")) return messageComponent;
		else if(s.equals("Option[]")) return new Object[]{ messageString,
				messageIcon, messageComponent, messageObject};
		else return null;
	}
	
	/**
	 * ������ȡ��ǰѡ���ѡ������
	 * @return Object[] ����������������options����ѡ��
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
	 * ˽���ڲ��� ʵ��ActionListener�ӿ� ��show��ť����
	 */
	private class ShowAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
//			���ѡ�����ȷ�϶Ի���
			if(typePanel.getSelection().equals("Confirm"))
				JOptionPane.showConfirmDialog(OptionDialogFrame.this, getMessage(), "ȷ�϶Ի���", 
						getType(optionTypePanel), getType(messageTypePanel));
			
//			���ѡ���������Ի���
			else if(typePanel.getSelection().equals("Input")) {
				//�ı�������
				if(inputPanel.getSelection().equals("Text field"))
					JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), 
							"�ı�������", getType(messageTypePanel));
				else JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(),
						"��Ͽ�����", getType(messageTypePanel), null, 
						new String[] { "Yellow", "Blue", "Red" }, "Blue");
			}
			else if (typePanel.getSelection().equals("Message")) 
				JOptionPane.showMessageDialog(OptionDialogFrame.this, getMessage(), "��Ϣ�Ի���", 
						getType(messageTypePanel));
			else if (typePanel.getSelection().equals("Option"))
				JOptionPane.showOptionDialog(OptionDialogFrame.this, getMessage(), "ѡ��Ի���",
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
//		Ϊ Graphics2D ���������� Paint ����
		g2.fill(rect);
		g2.setPaint(Color.BLUE);
//		���εĿ������ɫ �ڲ��ǻ�ɫ
		g2.draw(rect);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(10, 10);
	}
}
