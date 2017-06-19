package chapter09.toolBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 这个类创建一个工具栏和一个菜单栏来改变面板的背景颜色
 * @version 1.8 2017/4/29
 * @author caoting
 */
public class ToolBarFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private JPanel panel;
	
	public ToolBarFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);
		Action blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
		Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
		
		Action exitAction = new AbstractAction("Exit", new ImageIcon("exit.gif")) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		};
		
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");
		
		JToolBar bar = new JToolBar();
		bar.add(redAction);
		bar.add(blueAction);
		bar.add(yellowAction);
		bar.addSeparator();
		bar.add(exitAction);
		
		add(bar, BorderLayout.NORTH);
		
//		新建菜单栏
		JMenu menu = new JMenu("Color");
		menu.add(redAction);
		menu.add(blueAction);
		menu.add(yellowAction);
		menu.add(exitAction);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	/**
	 * 一个设置面板背景颜色的内部类
	 */
	class ColorAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ColorAction(String name, Icon icon, Color c) {
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, name + " background");
			putValue("color", c);
		}
		
		public void actionPerformed(ActionEvent event) {
			Color c = (Color) getValue("color");
			panel.setBackground(c);
		}
	}
}
