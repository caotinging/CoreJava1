package chapter09.checkBox;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 复选框改变字体粗细和正斜
 * @version 1.8 2017/4/23
 * @author caoting
 */
public class CheckBoxFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int TEXTAREA_ROWS = 8;
	private static final int TEXTAREA_COLUMN = 20;
	private static final int FONTSIZE = 24;
	private JTextArea textArea;
	private JCheckBox bold;
	private JCheckBox italic;
	
	public CheckBoxFrame() {
		textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMN);
		JPanel centerPanel = new JPanel();
		textArea.setFont(new Font("serif", Font.BOLD, FONTSIZE));
		
		centerPanel.add(textArea);
		add(centerPanel, BorderLayout.CENTER);
		JPanel southPanel = new JPanel();
		
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		bold.setSelected(true);
		southPanel.add(bold);
		
		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		southPanel.add(italic);
		
		add(southPanel, BorderLayout.SOUTH);	
		pack();
	}
	
ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			int mode = 0;
			if(bold.isSelected())
				mode += Font.BOLD;
			if(italic.isSelected())
				mode += Font.ITALIC;
			textArea.setFont(new Font("serif", mode, FONTSIZE));
		}
	};
}
