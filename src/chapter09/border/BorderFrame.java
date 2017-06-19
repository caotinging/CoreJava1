package chapter09.border;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class BorderFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup group;
	private JPanel buttonPanel;
	private JPanel demoPanel;
	
	public BorderFrame() {
		buttonPanel = new JPanel();
		demoPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
		addRadioButton("Etched", BorderFactory.createEtchedBorder());
		addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
		addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
		addRadioButton("Empty", BorderFactory.createEmptyBorder());
		
		Border etched = BorderFactory.createEtchedBorder();
		Border title = BorderFactory.createTitledBorder(etched, "Border Types");
		buttonPanel.setBorder(title);
		
		setLayout(new GridLayout(2, 1));
		add(buttonPanel);
		add(demoPanel);
		pack();
	}
	
	public void addRadioButton(String name, final Border border) {
		JRadioButton button = new JRadioButton(name);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				demoPanel.setBorder(border);
			}
		});
		group.add(button);
		buttonPanel.add(button);
	}
}
