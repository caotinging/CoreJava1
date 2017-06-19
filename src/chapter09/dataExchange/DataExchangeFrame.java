package chapter09.dataExchange;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * ����һ����ܣ�����в˵�File�еĲ˵���connect����һ���Ի���
 * �����û����������Ժ���OK��ʾ���ı���
 * @version 1.8 2017/5/3
 * @author caoting
 */
public class DataExchangeFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static final int TEXT_ROWS = 20;
	private static final int TEXT_COLUMNS = 40;
	private PasswardChooser dialog = null;
	private JTextArea textArea;
	
	public DataExchangeFrame() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem connectItem = new JMenuItem("Connect");
		connectItem.addActionListener(new ConnectAction());
		file.add(connectItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(event -> {
			System.exit(0);
		});
		file.add(exitItem);
		
		textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		add(textArea, BorderLayout.CENTER);
		pack();
	}
	
	private class ConnectAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(dialog == null) {
				dialog = new PasswardChooser();
			    dialog.setUser(new User("your name", null));
			}
			
			if(dialog.showDialog(DataExchangeFrame.this, "Connect")) {
//				����û��������OK��ť ���ȡ�û�������Ϣ�������ı���
				User u = dialog.getUser();
				textArea.append("User name : " + u.getName() + "\nPassword : "
				+ (new String(u.getPassword())) + "\n");
//				�������ı�׷�ӵ��ĵ���β
			}
		}
		
	}
}
