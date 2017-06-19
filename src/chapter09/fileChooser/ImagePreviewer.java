package chapter09.fileChooser;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ImagePreviewer extends JLabel {

	/**
	 * �������һ���ļ�ѡ��������Ϊ������ʾ�ļ�Ԥ��ͼƬ
	 */
	private static final long serialVersionUID = 1L;
	
	public ImagePreviewer(JFileChooser chooser) {
		setPreferredSize(new Dimension(100, 100));
		setBorder(BorderFactory.createEtchedBorder());
		
		chooser.addPropertyChangeListener(event -> {
			if(event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
				File f = (File) event.getNewValue();
				
				if(f == null) {
					setIcon(null);
//					��������Label��Ҫ��ʾ��ͼ�ꡣ��� icon ֵΪ null����ʲôҲ����ʾ
					return;
				}
				
				ImageIcon icon = new ImageIcon(f.getPath());
				
//				����ߴ�̫��
				if(icon.getIconWidth() > getWidth())
					icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), - 1, Image.SCALE_DEFAULT));
//				width - ��ͼ�����ŵ��Ŀ�ȡ�
//				height - ��ͼ�����ŵ��ĸ߶ȡ�
//				hints - ָʾ����ͼ������ȡ�����㷨���͵ı�־�� 

//				public static final int SCALE_DEFAULTʹ��Ĭ�ϵ�ͼ�������㷨
//				��� width �� height Ϊ���������滻��ֵ��ά�ֳ�ʼͼ��ߴ�ĸ߿�ȡ�
//				��� width �� height ��Ϊ������ʹ�ó�ʼͼ��ߴ�
				setIcon(icon);
			}
		});
	}
}
