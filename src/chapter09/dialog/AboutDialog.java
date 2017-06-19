package chapter09.dialog;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * ����Ի�������ʾһ����ϢȻ��ȴ�ʹ���ߵ��OK��ť
 * @version 1.8 2017/5/2
 * @author caoting
 */
public class AboutDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	public AboutDialog(JFrame owner) {
		super(owner, "About Dialog", true);
//		����JDialog�Ĺ�����public JDialog(Dialog owner,String title,boolean modal)
//		owner - ��ʾ�öԻ���������� Dialog������˶Ի���û�������ߣ���Ϊ null
//		title - �öԻ���ı�����������ʾ�� String
//		modal - ָ���Ի�������ʾʱ�Ƿ������û����������㴰�����롣
//		���Ϊ true����ģʽ�������Ա�����Ϊ DEFAULT_MODALITY_TYPE������Ի�������ģʽ�ġ� 
		
		add(new JLabel("<html><h1><i>Core Java</h1></i><hr>By Cay Horstman and Gary Cornell</html>"),
				BorderLayout.CENTER);
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
//				setVisible(boolean b)���ݲ��� b ��ֵ��ʾ�����ش� Dialog�� 
			}
		});
		JPanel panel = new JPanel();
		panel.add(ok);
		
		setSize(250, 200);
		add(panel, BorderLayout.SOUTH);
	}
}
