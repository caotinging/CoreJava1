package chapter10.resource;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

/**
 * @version 1.8 2017/5/6
 * @author caoting
 */
public class ResourceTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new ResourceFrame();
			frame.setTitle("Resource Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

/**
 * 一个定位图片和文本资源的框架类
 */
class ResourceFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ResourceFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		URL aboutURL = getClass().getResource("about.gif");
		Image img = new ImageIcon(aboutURL).getImage();
		setIconImage(img);
//		设置要作为此窗口图标显示的图像
		
		JTextArea textArea = new JTextArea();
		InputStream stream = getClass().getResourceAsStream("about.txt");
		try(Scanner in = new Scanner(stream, "UTF-8")) {
			while(in.hasNext()) 
//				 hasNextXxx()：是否还有下一个输入项，
//				其中Xxx可以是Int、Long等代表基本数据类型的字符串。
//				如果需要判断是否包含下一个字符串，可以省略Xxx.
				textArea.append(in.nextLine() + "\n");
//			将给定文本追加到文本区的当前文本。 
		}
		add(textArea);
	}
}
