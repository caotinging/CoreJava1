package chapter14.swing;

import javax.swing.*;

import java.awt.EventQueue;
import java.util.*;

public class GoodWorkThread implements Runnable {
	private JComboBox<Integer> combo;
	private Random generator;
	
	public GoodWorkThread(JComboBox<Integer> combo) {
		this.combo = combo;
		generator = new Random();
	}
	
	public void run() {
		try {
			while(true) {
				EventQueue.invokeLater(() -> {
					int i = Math.abs(generator.nextInt());
					if(i % 2 == 0) combo.insertItemAt(i, 0);
					else if(combo.getItemCount() > 0)
						combo.removeItemAt(i % combo.getItemCount());
				});
				Thread.sleep(1);
			}
		}
		catch(InterruptedException e) {
		}
	}
}
