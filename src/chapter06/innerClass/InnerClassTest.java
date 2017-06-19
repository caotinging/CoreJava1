package chapter06.innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of inner classes.
 * @version 1.7.0_80 2017/4/9
 * @author caoting
 */
public class InnerClassTest {
	public static void main (String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		//keep program running until user selects "OK"
		JOptionPane.showMessageDialog(null, "关闭程序吗？");
		System.exit(0);
	}
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock {
	private int interval = 0;
	private boolean beep;
	
	/**
	 * Constructions a talking clock
	 * @param interval the interval between messages (in milliseconds).
	 * @param beep true if the clock should beep
	 */
	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}
	
	/**
	 * Starts the clock
	 */
	public void start () {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	public class TimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Date now = new Date();
			System.out.println("现在时间是: "+now);
			if (beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}
