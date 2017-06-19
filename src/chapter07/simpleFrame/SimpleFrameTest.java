package chapter07.simpleFrame;

import java.awt.*;
import javax.swing.*;

/**
 * This program shows a blank frame
 * @version 1.7.0_80 2017/4/11
 * @author caoting
 */
public class SimpleFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//frame.setUndecorated(true);
				//��������ǹر����п����ɫ
				frame.setVisible(true);
			}
		});
	}
}

class SimpleFrame extends JFrame {
	/*
	 * ���������������ʱҲ������ΪɶҪ�ü�Ȼ�Ǳ�������ʾ���õľ������Ű� ��֮�����о���Ͷ���
	 */
	private static final long serialVersionUID = 3140674431190446603L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
