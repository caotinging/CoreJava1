package chapter09.text;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 输入用户名和密码insert按钮输出
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
		northPanel.add(new JLabel("用户名:", JLabel.LEFT));
		northPanel.add(textField);
		northPanel.add(new JLabel("密码:", JLabel.LEFT));
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
				textArea.append("用户名: " + textField.getText() +"\n" + "密码: " 
			+ new String(password.getPassword()) + "\n");
			}
		});
		//textArea.setLineWrap(true);自动换行特性
		add(southPanel, BorderLayout.SOUTH);
		pack();
	}
}
