package chapter08.action;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 这个类提供了多种改变背景颜色的方法 可以通过点击按钮
 * 也可以通过按键（CTRL+Y）黄色，（CTRL+B）蓝色，（CTRL+R）红色
 * @version 1.8 2017/4/17
 * @author caoting
 */
public class ActionTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ActionFrame();
				frame.setTitle("change");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ActionFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ActionFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		buttonPanel = new JPanel();
		
		Action yellowAction = new ColorAction ("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
		Action blueAction = new ColorAction ("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
		Action redAction = new ColorAction ("Red", new ImageIcon("red-ball.gif"), Color.RED);
		
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		add(buttonPanel);
		
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
		}
	
	public class ColorAction extends AbstractAction {
			private static final long serialVersionUID = 1L;
			/**
			 * 构造一个改变背景颜色的动作
			 * @param name 按钮的名字
			 * @param icon 按钮前面的图标
			 * @param c 背景颜色
			 */
			
			public ColorAction(String name, ImageIcon icon, Color c) {
				putValue(Action.NAME, name);
				this.putValue(Action.SMALL_ICON, icon);
				putValue(Action.SHORT_DESCRIPTION, "将面板的背景颜色更换为:" + name.toLowerCase());
				putValue("color", c);
			}
			
			public void actionPerformed(ActionEvent event) {
				Color c = (Color) getValue("color");
				buttonPanel.setBackground(c);
		}
	}
}
