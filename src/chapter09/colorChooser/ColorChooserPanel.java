package chapter09.colorChooser;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ColorChooserPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public ColorChooserPanel() {
		JButton modalButton = new JButton("Modal");
		modalButton.addActionListener(new ModalListener());
		add(modalButton);
		
		JButton modelessButton = new JButton("Modeless");
		modelessButton.addActionListener(new ModelessListener());
		add(modelessButton);
		
		JButton immediateButton = new JButton("Immediate");
		immediateButton.addActionListener(new ImmediateListener());
		add(immediateButton);
	}
	
	/**
	 * ���˽������modal��ť�ļ����� һ��ģʽ��ɫѡ����
	 */
	private class ModalListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color defaultColor = getBackground();
			Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set Background", defaultColor);
			/*��ʾ��ģʽ����ɫѡȡ���������ضԻ���֮ǰһֱ������
			 * ����û����� "OK" ��ť����˷�������/�ͷŶԻ��򲢷�����ѡ��ɫ��
			 * ����û����� "Cancel" ��ť������û�а� "OK" ������¹رնԻ���
			 * ��˷���������/�ͷŶԻ��򲢷��� null 
			 */
			
			if(selected != null)
				setBackground(selected);
		}
	}
	
	/**
	 * ���˽���ڲ�����modeless��ť�ļ����� һ����ģʽ��ɫѡ����
	 */
	private class ModelessListener implements ActionListener {
		private JDialog dialog;
		private JColorChooser chooser;
		
		public ModelessListener() {
			chooser = new JColorChooser();
			dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color", false, chooser,
					event-> setBackground(chooser.getColor()), null);
			/*���������ذ���ָ�� ColorChooser ���� "OK"��"Cancel" �� "Reset" ��ť���¶Ի���
			 * ������� "OK" �� "Cancel" ��ť����Ի����Զ����أ���δ�ͷţ���
			 * ������� "Reset" ��ť������ɫѡȡ������ɫ����Ϊ��һ���ڶԻ����ϵ��� show ʱ���õ���ɫ��
			 * ���ҶԻ�����Ȼ��ʾ
			 */
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
	}
	
	/**
	 * ���˽���ڲ�����immediate��ť�ļ�����  һ��û�а�ťѡ����ɫ���̸ı䱳����ɫ����ģʽ��ɫѡ����
	 */
	private class ImmediateListener implements ActionListener {
		private JDialog dialog;
		private JColorChooser chooser;
		
		public ImmediateListener() {
			chooser = new JColorChooser();
			chooser.getSelectionModel().addChangeListener(event -> {
				setBackground(chooser.getColor());
			});
			
			dialog = new JDialog((Frame) null, false);
//			����(Dialog owner, boolean modal)����һ������ָ�������� Dialog ��ģʽ�ĶԻ���
			
			dialog.add(chooser);
			dialog.pack();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
	}
}
