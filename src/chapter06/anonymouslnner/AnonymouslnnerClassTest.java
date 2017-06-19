package chapter06.anonymouslnner;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates anonymous inner classes
 * @version 1.7.0_80 2017/4/9
 * @author caoting
 */
public class AnonymouslnnerClassTest {
	public static void main(String[] args) {
		//TalkingClock2默认构造器
		TalkingClock2 clock = new TalkingClock2();
		clock.start(1000, true);
		
		//keep program running until user selects"OK"
		JOptionPane.showMessageDialog(null, "停止程序吗？");
		System.exit(0);
	}
}

/**
 * A clock the prints the time in regular intervals 222
 */
class TalkingClock2 {
	
	/**
	 * Starts the clock
	 * @param interval the interval between message (in milliseconds)
	 * @param beep true if the clock should beep
	 */
	public void start(int interval, final boolean beep) {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Date now = new Date();
				System.out.println("现在是北京时间:"+now);
				if(beep) Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer t = new Timer(interval, listener);
		t.start();
	}
}

