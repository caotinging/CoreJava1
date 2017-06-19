package chapter09.menu;

import java.awt.event.*;

import javax.swing.*;

/**
 * ���������ʾ��: Ƕ�ײ˵������ò˵����ѡ��͵�ѡ��ť�˵�������˵�
 * �Լ���ݼ��ͼ�����
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
	
	//����������Ƶļ���
	class TestAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public TestAction(String name) {
			super(name);
			//super��������: ���ø����е�ĳһ�����캯����Ӧ��Ϊ���캯���еĵ�һ����䣩
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
		
		//�����ڲ���   fileMenu�˵��Ĳ˵���Exit ����:�˳�����
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
		
		//���帴ѡ��˵��� ����������save �� save as ���úͽ������
		readonlyItem = new JCheckBoxMenuItem("Read-Only");
		readonlyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean saveOk = ! readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
				System.out.println("Read-Only Selected");
				//�����ڲ��಻Ҫ�þֲ�������saveItem�� ������ȫ�ֱ�����savaAction��
				//JMenuItem��Action����setEnable()���� ���û����ò˵������������set����������һ��
			}
		});
		
		//�½���ť�� ��ӵ�ѡ��ť
		ButtonGroup group = new ButtonGroup();
		
		JCheckBoxMenuItem insertItem = new JCheckBoxMenuItem("Insert");
		insertItem.addActionListener(new TestAction("Insert"));
		insertItem.setSelected(true);
		JCheckBoxMenuItem overtypeItem = new JCheckBoxMenuItem("Overtype");
		overtypeItem.addActionListener(new TestAction("Overtype"));
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		//������ͼ���Ĳ˵���:)
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
		
//		����edieMenu�ڵ��Ӳ˵�optionMenu
		JMenu optionMenu = new JMenu("Options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);
		
//		ΪhelpMenu�˵����ÿ�ݼ�
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		
		JMenuItem indexItem = helpMenu.add(new TestAction("Index"));
		indexItem.setMnemonic('I');
		
//		Ϊ�������ÿ�ݼ�
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		menu.add(fileMenu);
		menu.add(editMenu);
		menu.add(helpMenu);
		
//		����һ�������˵�
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		
		add(panel);
	}
}
