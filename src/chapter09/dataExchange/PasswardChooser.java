package chapter09.dataExchange;

import java.awt.*;
import javax.swing.*;

public class PasswardChooser extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField username;
	private JPasswordField password;//一定要记得在构造器中初始化
	private JButton okButton;
	private Boolean ok;
	private JDialog dialog;
	
	public PasswardChooser() {
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("User name :"));
		panel.add(username = new JTextField(""));
		panel.add(new JLabel("Password :"));
		panel.add(password = new JPasswordField(""));
		add(panel, BorderLayout.CENTER);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(event -> {
			ok = true;
			dialog.setVisible(false);
		});
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(event -> {
			dialog.setVisible(false);
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * 设置对话框默认值
	 * @param u 默认用户信息
	 */
	public void setUser(User u) {
		username.setText(u.getName());
	}
	
	/**
	 * 获取对话框输入
	 */
	public User getUser() {
		return new User(username.getText(), password.getPassword());
	}
	
	/**
	 * 把面板用对话框展示出来
	 */
	public boolean showDialog (Component parent, String title) {
		ok = false;
		
		Frame owner = null;
		if(parent instanceof Frame)
			owner = (Frame) parent;
		else owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
//		public static Container getAncestorOfClass(Class<?> c,Component comp)
//		在组件层次结构中搜索上面的 comp 的便捷方法，返回它找到的类 c 的第一个对象。如果无法找到类 c，可以返回 null。
		
//		第一次调用showDialog或者更改拥有者框架
		if(dialog == null || dialog.getOwner() != owner) {
			dialog = new JDialog(owner, true);
			dialog.add(this);//this 是整个面板
			dialog.getRootPane().setDefaultButton(okButton);//设置默认按钮
			dialog.pack();
		}
		
		dialog.setTitle(title);
		dialog.setVisible(true);
		return ok;
	}
}
