package chapter09.dialog;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 这个对话框类显示一条信息然后等待使用者点击OK按钮
 * @version 1.8 2017/5/2
 * @author caoting
 */
public class AboutDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	public AboutDialog(JFrame owner) {
		super(owner, "About Dialog", true);
//		超类JDialog的构造器public JDialog(Dialog owner,String title,boolean modal)
//		owner - 显示该对话框的所有者 Dialog；如果此对话框没有所有者，则为 null
//		title - 该对话框的标题栏中所显示的 String
//		modal - 指定对话框在显示时是否阻塞用户向其他顶层窗口输入。
//		如果为 true，则模式类型属性被设置为 DEFAULT_MODALITY_TYPE；否则对话框是无模式的。 
		
		add(new JLabel("<html><h1><i>Core Java</h1></i><hr>By Cay Horstman and Gary Cornell</html>"),
				BorderLayout.CENTER);
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
//				setVisible(boolean b)根据参数 b 的值显示或隐藏此 Dialog。 
			}
		});
		JPanel panel = new JPanel();
		panel.add(ok);
		
		setSize(250, 200);
		add(panel, BorderLayout.SOUTH);
	}
}
