package chapter08.plafTest;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;

/**
 * 这个类利用button改变frame的观感
 * @version 1.8 2017/4/17
 * @author caoting
 */
public class PlafTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new PlafFrame();
				frame.setTitle("look and feel");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class PlafFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel buttonPanel;
	
	public PlafFrame() {
		buttonPanel = new JPanel();
		
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info : infos) {
			makeButton(info.getName(), info.getClassName());
			System.out.println(info.getName() +"  " + info.getClassName());
		}
		
		add(buttonPanel);
		pack();
	}
	
	public void makeButton(String name, final String platName) {
		JButton button = new JButton(name);
		buttonPanel.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager.setLookAndFeel(platName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
					pack();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
