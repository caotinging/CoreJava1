package chapter08.button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.8 2017/4/16
 * @author caoting
 */
public class ButtonTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ButtonFrameSimple();
				frame.setTitle("change");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ButtonFrameSimple extends JFrame  {
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void makeButton(String name, final Color backgroungColor) {
		JButton button = new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				buttonPanel.setBackground(backgroungColor);
			}
		});
	}
	public ButtonFrameSimple() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		
		makeButton("Yellow", Color.YELLOW);
		makeButton("Blue", Color.BLUE);
		makeButton("Red", Color.red);
		
		add(buttonPanel);//之前运行不成功原来是忘了这一句 哈哈哈哈
	}
}
