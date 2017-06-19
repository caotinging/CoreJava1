package chapter09.menu;

import java.awt.event.*;

import javax.swing.*;

/**
 * 这个程序演示了: 嵌套菜单，禁用菜单项，复选框和单选按钮菜单项，弹出菜单
 * 以及快捷键和加速器
 * @version 1.8 2017/4/28
 * @author caoting
 */
public class MenuFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	
	//输出动作名称的简单类
	class TestAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public TestAction(String name) {
			super(name);
			//super（参数）: 调用父类中的某一个构造函数（应该为构造函数中的第一条语句）
		}
		public void actionPerformed(ActionEvent event) {
			System.out.println(getValue(Action.NAME) + " Selected");
		}
	}
	
	public MenuFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new TestAction("New"));
		
		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		
		fileMenu.addSeparator();
		
		saveAction = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		
		fileMenu.addSeparator();
		
		//匿名内部类   fileMenu菜单的菜单项Exit 功能:退出程序
		JMenuItem exitItem = fileMenu.add(new AbstractAction("Exit") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
		
		//定义复选框菜单项 监听器设置save 和 save as 启用和禁用情况
		readonlyItem = new JCheckBoxMenuItem("Read-Only");
		readonlyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean saveOk = ! readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
				System.out.println("Read-Only Selected");
				//匿名内部类不要用局部变量（saveItem） 尽量用全局变量（savaAction）
				//JMenuItem和Action都有setEnable()方法 禁用或启用菜单项（动作）可以set关联的任意一个
			}
		});
		
		//新建按钮组 添加单选按钮
		ButtonGroup group = new ButtonGroup();
		
		JCheckBoxMenuItem insertItem = new JCheckBoxMenuItem("Insert");
		insertItem.addActionListener(new TestAction("Insert"));
		insertItem.setSelected(true);
		JCheckBoxMenuItem overtypeItem = new JCheckBoxMenuItem("Overtype");
		overtypeItem.addActionListener(new TestAction("Overtype"));
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		//定义有图案的菜单项:)
		Action cutAction = new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction = new TestAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction = new TestAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
//		定义edieMenu内的子菜单optionMenu
		JMenu optionMenu = new JMenu("Options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);
		
//		为helpMenu菜单设置快捷键
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		
		JMenuItem indexItem = helpMenu.add(new TestAction("Index"));
		indexItem.setMnemonic('I');
		
//		为动作设置快捷键
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		menu.add(fileMenu);
		menu.add(editMenu);
		menu.add(helpMenu);
		
//		设置一个弹出菜单
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		
		add(panel);
	}
}
