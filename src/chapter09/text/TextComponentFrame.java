package chapter09.text;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * �����û���������insert��ť���
 * @version 1.8 2017/4/23
 * @author caoting
 */
public class TextComponentFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int TEXTAREA_ROWS = 8;
	private static final int TEXTAREA_COLUMN = 20;
	
	public TextComponentFrame() {
		final JTextField textField = new JTextField();
		final JPasswordField password = new JPasswordField();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(new JLabel("�û���:", JLabel.LEFT));
		northPanel.add(textField);
		northPanel.add(new JLabel("����:", JLabel.LEFT));
		northPanel.add(password);
		
		add(northPanel, BorderLayout.NORTH);
		
		final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMN);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
		
		JButton insertButton = new JButton("insert");
		JPanel southPanel = new JPanel();
		southPanel.add(insertButton);
		
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textArea.append("�û���: " + textField.getText() +"\n" + "����: " 
			+ new String(password.getPassword()) + "\n");
			}
		});
		//textArea.setLineWrap(true);�Զ���������
		add(southPanel, BorderLayout.SOUTH);
		pack();
	}
}
