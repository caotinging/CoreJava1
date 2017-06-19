package chapter09.gridbag;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

/**
 * 这个类可以改变文本域的字体和尺寸
 * @version 1.8 2017/4/29
 * @author caoting
 */
public class FontFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static final int TEXT_ROWS = 10;
	private static final int TEXT_COLUMNS = 20;
	private JComboBox<String> face;
	private JComboBox<Integer> size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea sample;
	
	public FontFrame() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		ActionListener listener = EventHandler.create(ActionListener.class, this, "updateSample");
		/**
		 * public static <T> T create(Class<T> listenerInterface, Object target, String action)
		 * 参数：
		 * listenerInterface - 要为其创建代理的侦听器接口
		 * target - 将执行动作的对象
		 * action - 目标上的某个方法或（可能受限定的）属性的名称 
		 * 返回：实现 listenerInterface 的对象 
		 */
		
		JLabel faceLabel = new JLabel("Face :");
		face = new JComboBox<> (new String[] {"Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput"});
		face.addActionListener(listener);
		
		JLabel sizeLabel = new JLabel("Size :");
		size = new JComboBox<> (new Integer[] { 8, 10, 12, 15, 18, 24, 36, 48});
		size.addActionListener(listener);
		
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		
		sample = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		sample.setText("The quick brown fox jumps over the lazy dog");
		sample.setEditable(false);
		sample.setLineWrap(true);
		sample.setBorder(BorderFactory.createEtchedBorder());
		
		add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
		add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
		add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		add(bold, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
		add(italic, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
		add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
		pack();
		updateSample();
	}
	
	public void updateSample() {
		String fontFace = (String) face.getSelectedItem();
		int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);
		int fontSize = size.getItemAt(size.getSelectedIndex());
		
		Font font = new Font(fontFace, fontStyle, fontSize);
		sample.setFont(font);
		sample.repaint();
	}
}
