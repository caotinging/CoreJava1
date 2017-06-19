package chapter09.optionDialog;

import javax.swing.*;

/**
 * 这个类用垂直排列的一组单选框初始化一个面板
 * @author caoting
 */
public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup group;
	
	public ButtonPanel (String title, String... options) {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		允许垂直或水平布置多个组件的布局管理器
		
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
//		getActionCommand() 返回该按钮的动作命令字符串
//		getSelection()返回选择按钮的模型。
	}
}
