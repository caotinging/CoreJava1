package chapter14.swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingThreadTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new SwingThreadFrame();
			frame.setTitle("单一线程机制");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class SwingThreadFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public SwingThreadFrame() {
		final JComboBox<Integer> combo = new JComboBox<>();
		combo.insertItemAt(Integer.MAX_VALUE, 0);
		combo.setPrototypeDisplayValue(combo.getItemAt(0));
		combo.setSelectedIndex(0);
		
		JButton goodButton = new JButton("Good");
		goodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new GoodWorkThread(combo)).start();
			}
		});
		
		JButton badButton = new JButton("Bad");
		badButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new BadWorkThread(combo)).start();
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(goodButton);
		panel.add(badButton);
		panel.add(combo);
		
		add(panel);
		pack();
	}
}
