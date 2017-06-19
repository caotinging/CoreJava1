package chapter09.colorChooser;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ColorChooserPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public ColorChooserPanel() {
		JButton modalButton = new JButton("Modal");
		modalButton.addActionListener(new ModalListener());
		add(modalButton);
		
		JButton modelessButton = new JButton("Modeless");
		modelessButton.addActionListener(new ModelessListener());
		add(modelessButton);
		
		JButton immediateButton = new JButton("Immediate");
		immediateButton.addActionListener(new ImmediateListener());
		add(immediateButton);
	}
	
	/**
	 * 这个私有类是modal按钮的监听器 一个模式颜色选择器
	 */
	private class ModalListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color defaultColor = getBackground();
			Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set Background", defaultColor);
			/*显示有模式的颜色选取器，在隐藏对话框之前一直阻塞。
			 * 如果用户按下 "OK" 按钮，则此方法隐藏/释放对话框并返回所选颜色。
			 * 如果用户按下 "Cancel" 按钮或者在没有按 "OK" 的情况下关闭对话框，
			 * 则此方法将隐藏/释放对话框并返回 null 
			 */
			
			if(selected != null)
				setBackground(selected);
		}
	}
	
	/**
	 * 这个私有内部类是modeless按钮的监听器 一个无模式颜色选择器
	 */
	private class ModelessListener implements ActionListener {
		private JDialog dialog;
		private JColorChooser chooser;
		
		public ModelessListener() {
			chooser = new JColorChooser();
			dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color", false, chooser,
					event-> setBackground(chooser.getColor()), null);
			/*创建并返回包含指定 ColorChooser 窗格及 "OK"、"Cancel" 和 "Reset" 按钮的新对话框。
			 * 如果按下 "OK" 或 "Cancel" 按钮，则对话框自动隐藏（但未释放）。
			 * 如果按下 "Reset" 按钮，则将颜色选取器的颜色重置为上一次在对话框上调用 show 时设置的颜色，
			 * 并且对话框仍然显示
			 */
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
	}
	
	/**
	 * 这个私有内部类是immediate按钮的监听器  一个没有按钮选定颜色立刻改变背景颜色的无模式颜色选择器
	 */
	private class ImmediateListener implements ActionListener {
		private JDialog dialog;
		private JColorChooser chooser;
		
		public ImmediateListener() {
			chooser = new JColorChooser();
			chooser.getSelectionModel().addChangeListener(event -> {
				setBackground(chooser.getColor());
			});
			
			dialog = new JDialog((Frame) null, false);
//			参数(Dialog owner, boolean modal)创建一个具有指定所有者 Dialog 和模式的对话框。
			
			dialog.add(chooser);
			dialog.pack();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
	}
}
