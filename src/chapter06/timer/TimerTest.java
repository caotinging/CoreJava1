package chapter06.timer;

/**
 * @version 1.7.0_80 2017/4/8
 * @author caoting
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
//To resolve conflict with java.util.Timer

public class TimerTest {
	public static void main (String[] args) {
		ActionListener listener = new TimePrinter();
		
		//construct a timer that calls the listener
		//once every 10 seconds
		Timer t = new Timer(10000, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "你是猪吗?");
		System.exit(0);
	}
}

class TimePrinter implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		Date now = new Date();
		System.out.println("你怎么可能是猪 你是全天下最具有智慧的人 "+now);
		Toolkit.getDefaultToolkit().beep();
	}
}