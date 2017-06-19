package chapter09.dataExchange;

import java.awt.*;
import javax.swing.*;

public class PasswardChooser extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField username;
	private JPasswordField password;//һ��Ҫ�ǵ��ڹ������г�ʼ��
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
	 * ���öԻ���Ĭ��ֵ
	 * @param u Ĭ���û���Ϣ
	 */
	public void setUser(User u) {
		username.setText(u.getName());
	}
	
	/**
	 * ��ȡ�Ի�������
	 */
	public User getUser() {
		return new User(username.getText(), password.getPassword());
	}
	
	/**
	 * ������öԻ���չʾ����
	 */
	public boolean showDialog (Component parent, String title) {
		ok = false;
		
		Frame owner = null;
		if(parent instanceof Frame)
			owner = (Frame) parent;
		else owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
//		public static Container getAncestorOfClass(Class<?> c,Component comp)
//		�������νṹ����������� comp �ı�ݷ������������ҵ����� c �ĵ�һ����������޷��ҵ��� c�����Է��� null��
		
//		��һ�ε���showDialog���߸���ӵ���߿��
		if(dialog == null || dialog.getOwner() != owner) {
			dialog = new JDialog(owner, true);
			dialog.add(this);//this ���������
			dialog.getRootPane().setDefaultButton(okButton);//����Ĭ�ϰ�ť
			dialog.pack();
		}
		
		dialog.setTitle(title);
		dialog.setVisible(true);
		return ok;
	}
}
