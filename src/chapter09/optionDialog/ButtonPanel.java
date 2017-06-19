package chapter09.optionDialog;

import javax.swing.*;

/**
 * ������ô�ֱ���е�һ�鵥ѡ���ʼ��һ�����
 * @author caoting
 */
public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup group;
	
	public ButtonPanel (String title, String... options) {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		����ֱ��ˮƽ���ö������Ĳ��ֹ�����
		
		group = new ButtonGroup();
		for(String option : options) {
			JRadioButton button = new JRadioButton(option);
			button.setActionCommand(option);
			add(button);
			group.add(button);
			button.setSelected(option == options[0]);
		}
	}
	
	public String getSelection() {
		return group.getSelection().getActionCommand();
//		getActionCommand() ���ظð�ť�Ķ��������ַ���
//		getSelection()����ѡ��ť��ģ�͡�
	}
}
