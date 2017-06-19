package chapter09.colorChooser;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChooserFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel ;
	
	public ColorChooserFrame() {
		panel = new ColorChooserPanel();
		add(panel);
		pack();
	}
}
