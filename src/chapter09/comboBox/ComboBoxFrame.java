package chapter09.comboBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 这个类有个组合框用于调节文本域字体
 * @version 1.8 2017/4/25
 * @author caoting
 */
public class ComboBoxFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JTextArea textArea;
	private JComboBox<String> comboBox;
	private static final int DEFAULT_SIZE = 24;
	
	public ComboBoxFrame() {
		textArea = new JTextArea("Hello world!", 8, 20);
		textArea.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
		textArea.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		
		add(textArea, BorderLayout.CENTER);
		
		comboBox = new JComboBox<>();
		comboBox.addItem("Serif");
		comboBox.addItem("SansSerif");
		comboBox.addItem("Monospaced");
		comboBox.addItem("Dialog");
		comboBox.addItem("DialogInput");
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textArea.setFont(new Font(comboBox.getItemAt(comboBox.getSelectedIndex()),
						Font.PLAIN, DEFAULT_SIZE));
			}
		});
		
		JPanel comboPanel = new JPanel();
		comboPanel.add(comboBox);
		add(comboPanel, BorderLayout.SOUTH);
		pack();
	}
}
