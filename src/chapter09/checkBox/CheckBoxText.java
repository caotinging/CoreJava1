package chapter09.checkBox;

import java.awt.*;
import javax.swing.*;

/**
 * 这个类用于测试复选框
 * @version 1.8 2017/4/24
 * @author caoting
 */
public class CheckBoxText {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new CheckBoxFrame();
				frame.setTitle("复选框");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
