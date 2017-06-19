package chapter09.fileChooser;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ImagePreviewer extends JLabel {

	/**
	 * 这个类在一个文件选择器中作为附件显示文件预览图片
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
//					定义此组件Label将要显示的图标。如果 icon 值为 null，则什么也不显示
					return;
				}
				
				ImageIcon icon = new ImageIcon(f.getPath());
				
//				如果尺寸太大
				if(icon.getIconWidth() > getWidth())
					icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), - 1, Image.SCALE_DEFAULT));
//				width - 将图像缩放到的宽度。
//				height - 将图像缩放到的高度。
//				hints - 指示用于图像重新取样的算法类型的标志。 

//				public static final int SCALE_DEFAULT使用默认的图像缩放算法
//				如果 width 或 height 为负数，则替换该值以维持初始图像尺寸的高宽比。
//				如果 width 和 height 都为负，则使用初始图像尺寸
				setIcon(icon);
			}
		});
	}
}
